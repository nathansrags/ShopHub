package com.shophub.model;

import com.shophub.model.constants.DBConstants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "customer_cart", schema = DBConstants.SCHEMA)
public class CustomerCart {

    @EmbeddedId
    private CustomerCartId id;
}
