package com.shophub.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineItemTo implements Serializable {

    private Long id;
    private ProductTo product;
    private CartTo cart;
    private int quantity;
}
