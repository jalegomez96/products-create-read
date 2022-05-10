package com.example.demo.infrastructure.controllers;

import com.example.demo.products.application.models.ProductDTO;
import com.example.demo.shared.models.ApplicationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductsController {

    private List<ProductDTO> productDTOS;

    public ProductsController() {
        this.productDTOS = new ArrayList<ProductDTO>();
        productDTOS.add(new ProductDTO(1, "mouse", 100, 10, true, 1));
        productDTOS.add(new ProductDTO(2, "headphones", 1000, 10, true, 1));
        productDTOS.add(new ProductDTO(3, "burguer", 300, 10, true, 2));
        productDTOS.add(new ProductDTO(4, "shoes", 20, 10, true, 3));
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        ApplicationError applicationError = new ApplicationError("400", "Error");
        if (productDTO.getState())
            this.productDTOS.add(productDTO);
        return productDTO.getState()
                ? ResponseEntity.ok(productDTO)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
    }

    @RequestMapping(value = "/products/{state}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllProducts(@PathVariable("state") Boolean state) {
        ApplicationError applicationError = new ApplicationError("400", "Error");

        return state
                ? ResponseEntity.ok(this.productDTOS)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
    }
}
