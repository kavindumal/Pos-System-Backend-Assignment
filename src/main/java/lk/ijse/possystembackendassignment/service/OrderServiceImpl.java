package lk.ijse.possystembackendassignment.service;

import jakarta.transaction.Transactional;
import lk.ijse.possystembackendassignment.dao.CustomerDAO;
import lk.ijse.possystembackendassignment.dao.ItemDAO;
import lk.ijse.possystembackendassignment.dao.OrderDAO;
import lk.ijse.possystembackendassignment.dao.OrderDetailsDAO;
import lk.ijse.possystembackendassignment.dto.OrderDto;
import lk.ijse.possystembackendassignment.entity.CustomerEntity;
import lk.ijse.possystembackendassignment.entity.ItemEntity;
import lk.ijse.possystembackendassignment.entity.OrderDetailsEntity;
import lk.ijse.possystembackendassignment.util.AppUtil;
import lk.ijse.possystembackendassignment.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private final OrderDAO orderDAO;
    @Autowired
    private final CustomerDAO customerDAO;
    @Autowired
    private final ItemDAO itemDAO;
    @Autowired
    private final OrderDetailsDAO orderDetailsDAO;

    @Autowired
    private final Mapping mapping;
    @Override
    @Transactional
    public void saveOrders(OrderDto orderDto) {
        CustomerEntity customer = customerDAO.getCustomerEntitiesById(orderDto.getCustomerId());

        orderDto.setId(AppUtil.createOrderId());
        System.out.println(orderDto);
        var orderEntity = mapping.convertToOrderEntity(orderDto);
//        orderEntity.setCustomer(customer);
        List<OrderDetailsEntity> orderDetails = orderDto.getOrderDetailDtos().stream().map(orderDetailDto -> {
            OrderDetailsEntity orderDetailsEntity = mapping.convertToOrderDetailEntity(orderDetailDto);
            orderDetailsEntity.setOrder(orderEntity);
            orderDetailsDAO.save(orderDetailsEntity);

            ItemEntity item = itemDAO.findById(orderDetailDto.getItemid()).orElseThrow(() -> new RuntimeException("Item not found"));

            item.setQty(item.getQty() - orderDetailDto.getQty());
            orderDetailsEntity.setItem(item);
            itemDAO.save(item);
            return orderDetailsEntity;
        }).collect(Collectors.toList());

        orderEntity.setOrderDetailsList(orderDetails);

        orderDAO.save(orderEntity);

//        var savedOrder = orderDAO.save(orderEntity);
//        if(savedOrder == null){
//            throw new DataPersistFailedException("Cannot save");
//        }
    }


    @Override
    public List<OrderDto> getAllOrders()  {
        return mapping.convertToOrderDTOList(orderDAO.findAll());
    }
}
