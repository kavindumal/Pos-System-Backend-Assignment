package lk.ijse.possystembackendassignment.service;

import lk.ijse.possystembackendassignment.customObj.ItemResponse;
import lk.ijse.possystembackendassignment.dto.ItemDto;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDto itemDto);
    void updateItem(ItemDto itemDto);
    void deleteItem(String itemDto);
    ItemResponse getSelectedItem(String itemId);
    List<ItemDto> getAllItem();
}
