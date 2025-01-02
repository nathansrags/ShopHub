package com.shophub.model.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private String productName;
    private long productId;
    private long quantity;
    private BigDecimal productPrice;
    private BigDecimal discountPrice;
    private String description;
}