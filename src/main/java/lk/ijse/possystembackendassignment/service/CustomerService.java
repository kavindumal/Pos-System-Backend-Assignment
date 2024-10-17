package lk.ijse.possystembackendassignment.service;


import lk.ijse.possystembackendassignment.customObj.CustomerResponse;
import lk.ijse.possystembackendassignment.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDto customerDto);
    void updateCustomer(CustomerDto customerDto);
    void deleteCustomer(String customerId) throws ClassNotFoundException;
    CustomerResponse getSelectedCustomer(String customerId);
    List<CustomerDto> getAllCustomer();
}
