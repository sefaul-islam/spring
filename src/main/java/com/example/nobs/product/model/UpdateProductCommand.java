package com.example.nobs.product.model;


public class UpdateProductCommand {
    private Integer id;

    private Product product;

    public UpdateProductCommand(Integer id, Product product) {
        this.id = id;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }
}

