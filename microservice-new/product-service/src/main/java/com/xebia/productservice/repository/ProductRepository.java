package com.xebia.productservice.repository;

import com.xebia.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitleIsContainingIgnoreCase(String title);

}
