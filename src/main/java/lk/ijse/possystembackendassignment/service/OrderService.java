package lk.ijse.possystembackendassignment.service;

import lk.ijse.possystembackendassignment.dto.OrderDto;

import java.util.List;

public interface OrderService {

    void saveOrders(OrderDto orderDto);
    List<OrderDto> getAllOrders();

}
