package com.shophub.model.service;

import com.shophub.model.payload.ProductRequest;
import com.shophub.model.payload.ProductResponse;

public interface ProductService {

    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);

    public void deleteProductById(long productId);
}

