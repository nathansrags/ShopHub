package com.shophub.model.entity;

import com.shophub.model.constants.DBConstants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "customer_order", schema = DBConstants.SCHEMA)
public class CustomerOrder {

    @EmbeddedId
    private CustomerOrderId id;
}
