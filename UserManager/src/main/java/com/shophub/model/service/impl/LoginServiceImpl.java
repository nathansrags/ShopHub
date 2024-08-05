package com.shophub.model.service.impl;

import com.shophub.model.dao.CustomerDao;
import com.shophub.model.dao.RoleDao;
import com.shophub.model.service.ILoginService;
import com.shophub.model.dto.CustomerTo;
import com.shophub.model.entity.Customer;
import com.shophub.model.entity.Roles;
import com.shophub.model.exception.RecordNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements ILoginService<CustomerTo, Customer> {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CustomerTo findByEmail(String email) {
        Optional<Customer> opt = Optional.of(customerDao.findByUsernameOrEmail(email));
        opt.orElseThrow(RecordNotFoundException::new);
        return this.convertToDto(opt.get());
    }

    @Override
    public boolean userExist(String email) {
        return customerDao.existsByEmail(email);
    }

    @Override
    public List<CustomerTo> findAll() {
        List<Customer> dbList = customerDao.findAll();
        List<CustomerTo> tos = new ArrayList<>();
        for (Customer db : dbList) {
            CustomerTo to = this.convertToDto(db);
            tos.add(to);
        }
        return tos;
    }

    @Override
    public CustomerTo find(Long id) {
        Optional<Customer> opt = customerDao.findById(id);
        CustomerTo to = new CustomerTo();
        if (opt.isPresent()) {
            to = this.convertToDto(opt.get());
        } else {
            throw new RecordNotFoundException();
        }
        return to;
    }

    @Override
    public CustomerTo save(CustomerTo to) {
        Customer db = this.convertToEntity(to);
        db.setPassword(passwordEncoder.encode(to.getPassword()));
        Optional<Roles> opt = roleDao.findByRole("ROLE_ADMIN");
        Roles role;
        if (!opt.isPresent()) {
            role = checkRoleExist();
        } else {
            role = opt.get();
        }
        db.setRoles(Arrays.asList(role));
        Customer res = customerDao.save(db);
        return this.convertToDto(res);
    }

    private Roles checkRoleExist() {
        Roles role = new Roles();
        role.setRole("ROLE_ADMIN");
        role.setAccessType("ADMIN");
        return roleDao.save(role);
    }


    @Override
    public void remove(Long id) {
        Optional<Customer> opt = customerDao.findById(id);
        opt.orElseThrow(RecordNotFoundException::new);
        customerDao.delete(opt.get());
    }

    @Override
    public CustomerTo update(CustomerTo to) {
        Optional<Customer> opt = customerDao.findById(to.getCustomerId());
        opt.orElseThrow(RecordNotFoundException::new);
        Customer db = this.convertToEntity(to);
        db.setPassword(passwordEncoder.encode(to.getPassword()));
        db = customerDao.save(db);
        return this.convertToDto(db);
    }

    @Override
    public List<CustomerTo> saveAll(List<CustomerTo> t) {
        return List.of();
    }

    @Override
    public Customer convertToEntity(CustomerTo to) {
        Customer db = new Customer();
        mapper.map(to, db);
        return db;
    }

    @Override
    public CustomerTo convertToDto(Customer db) {
        CustomerTo to = new CustomerTo();
        mapper.map(db, to);
        return to;
    }

}
