package com.shophub.model.entity;

import com.shophub.model.constants.DBConstants;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "carts", schema = DBConstants.SCHEMA)
@Getter
@Setter
@EqualsAndHashCode
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LineItem> lineItems;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = false, updatable = false)
    private Timestamp updatedDate;

}