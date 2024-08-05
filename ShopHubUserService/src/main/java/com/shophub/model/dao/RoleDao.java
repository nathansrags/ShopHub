package com.shophub.model.dao;

import com.shophub.model.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Roles, Long> {

    Optional<Roles> findByRole(String role);
}
