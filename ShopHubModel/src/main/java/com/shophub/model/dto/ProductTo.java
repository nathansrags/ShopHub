package com.shophub.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTo implements Serializable {

    private Long productId;
    private String productName;
    private BigDecimal productPrice;
    private String description;
    private String discountPrice;
}
