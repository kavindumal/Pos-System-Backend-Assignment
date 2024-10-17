package lk.ijse.possystembackendassignment.dao;

import lk.ijse.possystembackendassignment.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends JpaRepository<ItemEntity,String> {
}
