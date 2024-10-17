package lk.ijse.possystembackendassignment.dto;

import lk.ijse.possystembackendassignment.customObj.ItemResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDto implements SuperDto, ItemResponse {

    private String id;
    private String name;
    private int qty;
    private double price;
}
