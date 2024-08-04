package com.shophub.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "address", schema = "ShopHub")
@Getter
@Setter
@EqualsAndHashCode
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "door_no")
    private String doorNo;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "layout")
    private String layout;
    @Column(name = "city")
    private String city;
    @Column(name = "pin_code")
    private String pinCode;

    // Getters and setters
}
