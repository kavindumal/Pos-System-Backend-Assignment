package lk.ijse.possystembackendassignment.dto;

import lk.ijse.possystembackendassignment.customObj.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto implements SuperDto, CustomerResponse {

    private String id;
    private String name;
    private String address;
    private double salary;
}
