package com.example.productapi.service;

import com.example.productapi.entity.Product;
import com.example.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product p = repository.findById(id).orElse(null);

        if (p != null) {
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            return repository.save(p);
        }

        return null;
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
}