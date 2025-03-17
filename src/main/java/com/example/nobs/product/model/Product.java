package com.example.nobs.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;



@Entity  //use this annotation for mapping the class's intances for mysql

@Table(name = "product")
public class Product {
    @Id //this is used for marking a primary key to identify the entity

    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto generates the first id with 1

    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Name is required")
    @NotBlank(message = "The name cannot be blank")
    @Column(name = "name")
    private String name;

    @Size(min = 20, message = "Description must be 20 characters long")
    @Column(name = "description")
    private String description;

    @PositiveOrZero(message = "Price cannnot be negative")
    @Column(name = "price")
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
