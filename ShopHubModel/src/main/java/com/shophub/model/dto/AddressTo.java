package com.shophub.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AddressTo implements Serializable {

    private Long id;
    private String doorNo;
    private String streetName;
    private String layout;
    private String city;
    private String pinCode;
}
