package lk.ijse.possystembackendassignment.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.possystembackendassignment.customObj.ItemErrorResponse;
import lk.ijse.possystembackendassignment.customObj.ItemResponse;
import lk.ijse.possystembackendassignment.dao.ItemDAO;
import lk.ijse.possystembackendassignment.dto.ItemDto;
import lk.ijse.possystembackendassignment.entity.ItemEntity;
import lk.ijse.possystembackendassignment.exception.DataPersistFailedException;
import lk.ijse.possystembackendassignment.exception.ItemNotFoundException;
import lk.ijse.possystembackendassignment.service.ItemService;
import lk.ijse.possystembackendassignment.util.AppUtil;
import lk.ijse.possystembackendassignment.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    @Autowired
    private final ItemDAO itemDAO;
    @Autowired
    private final Mapping mapping;

    @Override
    public void saveItem(ItemDto itemDto) {
        itemDto.setId(AppUtil.createItemId());
        var itemEntity = mapping.convertToItemEntity(itemDto);
        var savedItem = itemDAO.save(itemEntity);
        if(savedItem == null){
            throw new DataPersistFailedException("Cannot save");
        }
    }

    @Override
    public void updateItem(ItemDto itemDto) {
        Optional<ItemEntity> tmpItem = itemDAO.findById(itemDto.getId());
        System.out.println("tmpItem = " + tmpItem);
        if(!tmpItem.isPresent()){
            throw new ItemNotFoundException("Item not found");
        }else {
            tmpItem.get().setName(itemDto.getName());
            tmpItem.get().setPrice(itemDto.getPrice());
            tmpItem.get().setQty(itemDto.getQty());
        }
    }

    @Override
    public void deleteItem(String itemId) {
        Optional<ItemEntity> findId = itemDAO.findById(itemId);
        if(!findId.isPresent()){
            throw new ItemNotFoundException("Item not found");
        }else {
            itemDAO.deleteById(itemId);
        }
    }

    @Override
    public ItemResponse getSelectedItem(String itemId) {
        if(itemDAO.existsById(itemId)){
            return mapping.convertToItemDTO(itemDAO.getReferenceById(itemId));
        }else {
            return new ItemErrorResponse(0,"Item not found");
        }
    }

    @Override
    public List<ItemDto> getAllItem() {

        return mapping.convertToItemDTOList(itemDAO.findAll());

    }
}
