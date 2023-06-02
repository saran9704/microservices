package com.xebia.productservice.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String description;
    private Long price;
    @Column(name = "is_active")
    private Boolean isActive;



}
