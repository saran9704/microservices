package com.xebia.productservice.service;

import com.xebia.productservice.model.Product;

import java.util.List;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
public interface IProductService {
    List<Product> createProduct(Product product);

    List<Product> getAllProduct();

    List<Product> SearchProduct(String title);

    List<Product> updateProduct(Long id, Product product);

    List<Product> deleteProduct(Long id);

    Product getProductById(Long id);
}
