package com.shophub.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressTo {

    private Long id;
    private String doorNo;
    private String streetName;
    private String layout;
    private String city;
    private String pinCode;
}
