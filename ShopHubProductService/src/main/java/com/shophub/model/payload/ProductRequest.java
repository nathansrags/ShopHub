package com.shophub.model.payload;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductRequest {
    private String name;
    private BigDecimal price;
    private BigDecimal discountPrice;
    private long quantity;
}
