package com.shophub.model.service.impl;

import com.shophub.model.constants.ErrorConstants;
import com.shophub.model.entity.Inventory;
import com.shophub.model.entity.Product;
import com.shophub.model.exception.ProductServiceCustomException;
import com.shophub.model.payload.ProductRequest;
import com.shophub.model.payload.ProductResponse;
import com.shophub.model.repository.InventoryDao;
import com.shophub.model.repository.ProductDao;
import com.shophub.model.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService<ProductRequest, ProductResponse> {

    @Autowired
    private final ProductDao productRepository;
    @Autowired
    private final InventoryDao inventoryRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public List<ProductResponse> getProducts() {
        List<Product> dbList = productRepository.findAll();
        final List<ProductResponse> response = new ArrayList<>();
        for (Product db : dbList) {
            ProductResponse productResponse = convertToDto(db);
            response.add(productResponse);
        }
        return response;
    }

    @Override
    public String addProduct(ProductRequest productRequest) {
        log.info("ProductServiceImpl | addProduct is called");
        Inventory inventory = Inventory.builder().quantity(productRequest.getQuantity()).build();
        Product product
                = Product.builder()
                .productName(productRequest.getName())
                .productPrice(productRequest.getProductPrice())
                .discountPrice(productRequest.getDiscountPrice()).description(productRequest.getDescription())
                .inventory(inventory)
                .build();
        product = productRepository.save(product);

        log.info("ProductServiceImpl | addProduct | Product Created");
        log.info("ProductServiceImpl | addProduct | Inventory Created");
        log.info("ProductServiceImpl | addProduct | Product Id : {}", product.getProductId());
        return "Product Added to Inventory with Id " + product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {

        log.info("ProductServiceImpl | getProductById is called");
        log.info("ProductServiceImpl | getProductById | Get the product for productId: {}", productId);

        Product product
                = productRepository.findById(productId)
                .orElseThrow(
                        () -> new ProductServiceCustomException("Product with given Id not found", ErrorConstants.PRODUCT_NOT_FOUND));
        ProductResponse productResponse = convertToDto(product);
        log.info("ProductServiceImpl | getProductById | productResponse :{}", productResponse.toString());

        return productResponse;
    }

    @Override
    public String updateQuantity(long productId, long quantity) {

        log.info("Reduce Quantity {} for Id: {}", quantity, productId);

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException(
                        "Product with given Id not found",
                        "PRODUCT_NOT_FOUND"
                ));
        Inventory inventory = product.getInventory();

        if (quantity < 0 && inventory.getQuantity() < quantity) {
            throw new ProductServiceCustomException(
                    "Product does not have sufficient Quantity",
                    "INSUFFICIENT_QUANTITY"
            );
        }
        inventory.setQuantity(inventory.getQuantity() + quantity);
        productRepository.save(product);
        log.info("Product Quantity updated Successfully");
        return "Product Quantity updated Successfully";
    }

    @Override
    public void deleteProductById(long productId) {
        log.info("Product id: {}", productId);
        boolean exists = productRepository.existsById(productId);
        if (!exists) {
            throw new ProductServiceCustomException(
                    "Product with given with Id: " + productId + " not found:",
                    ErrorConstants.PRODUCT_NOT_FOUND);
        }
        log.info("Deleting Product with id: {}", productId);
        productRepository.deleteById(productId);
    }

    private ProductResponse convertToDto(Product db) {
        ProductResponse to = new ProductResponse();
        mapper.map(db, to);
        to.setQuantity(db.getInventory().getQuantity());
        return to;
    }
}