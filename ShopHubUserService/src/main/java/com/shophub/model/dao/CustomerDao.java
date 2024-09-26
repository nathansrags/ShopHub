package com.shophub.model.dao;

import com.shophub.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

     @Query("select cc from Customer cc where cc.email =?1")
    Customer findByUsernameOrEmail(final String email);
    Boolean existsByEmail(String email);
}
