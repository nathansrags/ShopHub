package com.shophub.model.service;

import java.util.List;

public interface ProductService<R, T> {

    List<T> getProducts();
    String addProduct(R r);

    T getProductById(long productId);

    String updateQuantity(long productId, long quantity);

    void deleteProductById(long productId);
}

