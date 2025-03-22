package com.example.nobs;

import com.example.nobs.product.ProductRepository;
import com.example.nobs.product.model.Product;
import com.example.nobs.product.services.GetProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GetProductServiceTest {
    @Mock //what to mock the response, in this case the productrepository
    private ProductRepository productrepository;

    @InjectMocks // the thing we are testing
    private GetProductService getproductservice;

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


        //when



        //then
    }
}
