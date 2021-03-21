package com.kas.security_agency.service;

import com.kas.security_agency.entity.Product;
import com.kas.security_agency.exception.ProductNotFoundException;
import com.kas.security_agency.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.getById(id).orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " was not found"));
    }

    public void deleteById(Long id){
        Product product = findById(id);
        productRepository.delete(product);
    }

}
