package com.shophub.model.controller;

import com.shophub.model.dto.CustomerTo;
import com.shophub.model.dto.ResponseTo;
import com.shophub.model.dto.UserTo;
import com.shophub.model.entity.Customer;
import com.shophub.model.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/")
@Slf4j
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final ILoginService<CustomerTo, Customer> loginServiceImpl;

    public AuthenticationController(AuthenticationManager authenticationManager, ILoginService<CustomerTo, Customer> loginServiceImpl) {
        this.authenticationManager = authenticationManager;
        this.loginServiceImpl = loginServiceImpl;
    }


    @PostMapping(value = "/login")
    public ResponseTo signIn(@RequestBody UserTo userTo) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userTo.getEmail(), userTo.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserTo user = loginServiceImpl.findByEmail(userTo.getEmail());
            return ResponseTo.builder().message("Sign in in success").statusCode(HttpStatus.OK).data(user).build();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e.getCause());
            throw new UsernameNotFoundException(e.getLocalizedMessage());
        }
    }

    @PostMapping(value = "/subscribe")
    public ResponseTo register(@RequestBody CustomerTo userTo) {
        var response = ResponseTo.builder();
        if (loginServiceImpl.userExist(userTo.getEmail())) {
            return new ResponseTo("Username already taken", HttpStatus.IM_USED);
        }
        var to = createEmptyCustomer(userTo);
        var customer = loginServiceImpl.save(to);
        response.message("user Registered Successfully").statusCode(HttpStatus.OK).data(customer);
        return response.build();
    }

    private CustomerTo createEmptyCustomer(UserTo userTo) {
        var to = new CustomerTo();
        to.setPassword(userTo.getPassword());
        to.setEmail(userTo.getEmail());
        return to;
    }

    @PostMapping(value = "/recoverpass")
    public ResponseTo recoverPass(@RequestBody CustomerTo userTo) {
        if (loginServiceImpl.userExist(userTo.getEmail())) {
            CustomerTo db = loginServiceImpl.findByEmail(userTo.getEmail());
            log.info(db.getCustomerId() + " User id");
            db.setPassword(userTo.getPassword());
            loginServiceImpl.update(db);
            return ResponseTo.builder().message("Password Updated").statusCode(HttpStatus.OK).build();
        } else {
            return ResponseTo.builder().message("User doesn't exist").statusCode(HttpStatus.NOT_FOUND).build();
        }
    }
}
