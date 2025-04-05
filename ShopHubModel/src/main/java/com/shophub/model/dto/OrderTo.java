package com.shophub.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderTo implements Serializable {
    private Long orderId;
    private Set<LineItemTo> lineItems;
}
