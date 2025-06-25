package com.shophub.model.controller;

import com.shophub.model.dto.CustomerTo;
import com.shophub.model.entity.Customer;
import com.shophub.model.exception.RecordNotFoundException;
import com.shophub.model.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class LoginController {

    @Autowired
    private ILoginService<CustomerTo, Customer> loginService;

    @GetMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<CustomerTo> get(@PathVariable Long id) {
        try {
            final CustomerTo response = loginService.find(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>(new CustomerTo(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerTo>> getAll() {
        final List<CustomerTo> response = loginService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerTo> add(@RequestBody CustomerTo to) {
        final CustomerTo response = loginService.save(to);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CustomerTo> delete(@PathVariable final Long id) {
        try {
            final CustomerTo response = loginService.find(id);
            loginService.remove(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>(new CustomerTo(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerTo> update(@RequestBody CustomerTo to) {
        try {
            final CustomerTo response = loginService.update(to);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RecordNotFoundException e) {
            return new ResponseEntity<>(new CustomerTo(), HttpStatus.NOT_FOUND);
        }
    }
}
