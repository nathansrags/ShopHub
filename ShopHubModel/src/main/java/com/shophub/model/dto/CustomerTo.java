package com.shophub.model.dto;

import com.shophub.model.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerTo implements Serializable {

    private Long customerId;
    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private Gender gender;
    private String password;
    private AddressTo billingAddress;
    private AddressTo shippingAddress;
}
