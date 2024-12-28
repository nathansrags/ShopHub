package com.shophub.model.repository;

import com.shophub.model.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Query("select e from Inventory e where e.productId=?1")
    public Inventory findByProductId(Long productId);
}
