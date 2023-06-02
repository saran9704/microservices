package com.xebia.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductRequest {
    private String title;
    private String description;
    private Long price;
    private Boolean isActive;
}
