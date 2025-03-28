package com.example.nobs.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Setter;


@Data
@Entity  //use this annotation for mapping the class's intances for mysql
@Setter
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

    public @PositiveOrZero(message = "Price cannnot be negative") Double getPrice() {
        return price;
    }

    public void setPrice(@PositiveOrZero(message = "Price cannnot be negative") Double price) {
        this.price = price;
    }

    public @Size(min = 20, message = "Description must be 20 characters long") String getDescription() {
        return description;
    }

    public void setDescription(@Size(min = 20, message = "Description must be 20 characters long") String description) {
        this.description = description;
    }

    public @NotNull(message = "Name is required") @NotBlank(message = "The name cannot be blank") String getName() {
        return name;
    }

    public void setName(@NotNull(message = "Name is required") @NotBlank(message = "The name cannot be blank") String name) {
        this.name = name;
    }
}
