package lk.ijse.possystembackendassignment.dao;

import lk.ijse.possystembackendassignment.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<OrderEntity,String> {
}
