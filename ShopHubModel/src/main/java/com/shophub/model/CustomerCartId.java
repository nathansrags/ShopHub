package com.shophub.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CustomerCartId {

    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "customer_id")
    private Long customerId;
}
