package com.xebia.productservice.controller;

import com.xebia.productservice.dto.ProductRequest;
import com.xebia.productservice.dto.Response;
import com.xebia.productservice.model.Product;
import com.xebia.productservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;


    @PostMapping(path = "create_product")
    public ResponseEntity<Response> createProduct(@RequestBody ProductRequest productRequest){

        Product product=Product.builder()
                .title(productRequest.getTitle())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .isActive(productRequest.getIsActive())
                .build();

       List<Product> productList= iProductService.createProduct(product);


        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("product",productList))
                        .message("new product added successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping(path = "get_product")
    public ResponseEntity<Response> getAllProduct(){

        List<Product> productList= iProductService.getAllProduct();


        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("product",productList))
                        .message("Getting all products successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }


    @GetMapping(path = "Search_product/{title}")
    public ResponseEntity<Response> SearchProduct(@PathVariable("title") String title){

        List<Product> productList= iProductService.SearchProduct(title);


        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("product",productList))
                        .message("product title contain with '"+ title+"'")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping(path = "update_product/{id}")
    public ResponseEntity<Response> updateProduct(@PathVariable("id") Long id,@RequestBody ProductRequest productRequest){

        Product product=Product.builder()
                .title(productRequest.getTitle())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .isActive(productRequest.getIsActive())
                .build();

        List<Product> productList= iProductService.updateProduct(id,product);


        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("product",productList))
                        .message("product updated successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping(path = "delete_product/{id}")
    public ResponseEntity<Response> deleteProduct(@PathVariable("id") Long id){


        List<Product> productList= iProductService.deleteProduct(id);


        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("product",productList))
                        .message("Deleted product by id :"+id+" successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping(path = "get_product/{id}")
    public ResponseEntity<Response> getProduct(@PathVariable("id") Long id){


        Product productList= iProductService.getProductById(id);


        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("product",productList))
                        .message("getting product by id :"+id+" successfully")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

}
