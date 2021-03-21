package com.kas.security_agency.controller;

import com.kas.security_agency.entity.Product;
import com.kas.security_agency.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public ResponseEntity<?> addProduct(@Valid @RequestBody Product product, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>(); //bindingResult.getFieldErrors()

            for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Product newProduct = productService.saveOrUpdateProduct(product);
        return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Product> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<?> getProductById(@PathVariable Long product_id){
        Product product = productService.findById(product_id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @PutMapping("/{product_id}")
    public ResponseEntity<?> putProductById(@RequestBody Product product){
        Product newProduct = productService.saveOrUpdateProduct(product);
        return new ResponseEntity<Product>(newProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{product_id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long product_id){
        productService.deleteById(product_id);
        return new ResponseEntity<String>("Product deleted", HttpStatus.OK);
    }
}
