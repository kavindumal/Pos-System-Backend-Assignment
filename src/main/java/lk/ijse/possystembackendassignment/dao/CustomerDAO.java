package lk.ijse.possystembackendassignment.dao;

import lk.ijse.possystembackendassignment.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerEntity,String> {
    CustomerEntity getCustomerEntitiesById(String id);
}
