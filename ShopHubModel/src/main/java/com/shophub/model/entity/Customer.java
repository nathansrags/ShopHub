package com.shophub.model.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMERS", schema = "ShopHub")
@Getter
@Setter
@EqualsAndHashCode
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "EMAIL")
    private String email;

    @Enumerated(EnumType.STRING) // Persist gender as enum name
    @Column(name = "GENDER")
    private Gender gender;

    @Column(name = "PASSWORD")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private Address billingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    private Address shippingAddress;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "customer_roles",
            joinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private List<Roles> roles = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = false, updatable = false)
    private Timestamp updatedDate;

    // Constructors, getters, setters, and other methods
    // ...
}
