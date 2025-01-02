package com.shophub.model.repository;

import com.shophub.model.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryDao extends JpaRepository<Inventory, Long> {

}
