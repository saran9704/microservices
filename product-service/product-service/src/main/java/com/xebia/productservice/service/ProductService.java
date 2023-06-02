package com.xebia.productservice.service;

import com.xebia.productservice.model.Product;
import com.xebia.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@Service
@Transactional
@Slf4j
public class ProductService implements IProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> createProduct(Product product) {
        log.info("saving new product : {}", product.getTitle());
        Product save = productRepository.save(product);

        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllProduct() {
        log.info("finding all products ");
        return productRepository.findAll();
    }

    @Override
    public List<Product> SearchProduct(String title) {
        log.info("Searching Product which contains : {} ", title);
        return productRepository.findByTitleIsContainingIgnoreCase(title);
    }

    @Override
    public List<Product> updateProduct(Long id, Product product) {
        log.info("updating existing product : {}", product.getTitle());
        Optional<Product> byId = productRepository.findById(id);
        if(byId.isPresent()){
            Product product1 = byId.get();
            product1.setTitle(product.getTitle());
            product1.setDescription(product.getDescription());
            product1.setPrice(product.getPrice());
            product1.setIsActive(product.getIsActive());
            productRepository.save(product1);
        }

        return productRepository.findAll();
    }

    @Override
    public List<Product> deleteProduct(Long id) {
        log.info("deleting product by id : {}", id);
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        log.info("getting product by id : {}", id);
        Optional<Product> byId = productRepository.findById(id);
        return byId.orElse(null);
    }
}
