package com.shophub.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "address", schema = "ShopHub")
@Getter
@Setter
@EqualsAndHashCode
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long addressId;

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

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = false, updatable = false)
    private Timestamp updatedDate;

    // Getters and setters
}
