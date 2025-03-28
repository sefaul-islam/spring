package com.example.nobs;

import com.example.nobs.exception.ProductNotFoundException;
import com.example.nobs.product.ProductRepository;
import com.example.nobs.product.model.Product;
import com.example.nobs.product.model.ProductDTO;
import com.example.nobs.product.services.GetProductServiceById;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GetProductServiceByIdTest {
    @Mock //what to mock the response, in this case the productrepository
    private ProductRepository productRepository;

    @InjectMocks // the thing we are testing
    private GetProductServiceById getproductservicebyid;

    @BeforeEach  // things we need before the test runs to set up properly
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_product_exists_when_get_product_service_return_product_dto(){
        //Given
        Product product= new Product();

        product.setId(1);
        product.setName("something");
        product.setDescription("cause this is all we knoww");
        product.setPrice(20.00);

        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        //when

        ResponseEntity<ProductDTO> response = getproductservicebyid.execute(1);

        //then
        assertEquals(ResponseEntity.ok(new ProductDTO(product)),response);

        // asserts the product repository was only called once
        verify(productRepository,times(1)).findById(1);
    }


    @Test
    public void given_product_does_not_exist_when_get_product_service_throw_product_not_found_exception(){

        //Given
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        // when and then
        assertThrows(ProductNotFoundException.class,()-> getproductservicebyid.execute(1));
        verify(productRepository,times(1)).findById(1);
    }
}
