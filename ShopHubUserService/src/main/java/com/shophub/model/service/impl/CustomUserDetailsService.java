package com.shophub.model.service.impl;

import com.shophub.model.dao.CustomerDao;
import com.shophub.model.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer user = Optional.ofNullable(customerDao.findByUsernameOrEmail(username)).orElseThrow(
                () -> new UsernameNotFoundException("User not found with the username " + username));
        Set<GrantedAuthority> authorities = user.getRoles().stream().map((role) -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toSet());
        return new User(user.getEmail(), user.getPassword(), authorities);
    }
}
