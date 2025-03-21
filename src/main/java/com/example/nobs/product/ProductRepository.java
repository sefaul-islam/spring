package com.example.nobs.product;

import com.example.nobs.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

     List<Product> findByNameContaining(String name);
     @Query("SELECT p FROM Product p Where p.name LIKE %:keyword% OR p.description LIKE %:keyword%")
     List<Product> findByNameOrDescriptionContaining(@Param("keyword") String string);
}
