package com.geekbrains.spring.mvc.services;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.repositories.BoxRepository;
import com.geekbrains.spring.mvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void init() {
        create("Пиво", 0.7);
        create("Шашлык", 5.5);
        create("Джинсы", 99.9);
        create("Iphone", 999.9);
        create("Машина", 19999.9);

    }

    public boolean del(Long id) {
        return this.productRepository.remove(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product create(String title, Double cost) {
        return productRepository.save(new Product(title, cost));
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Product find(Long id) {
        return productRepository.get(id);
    }

    public Product createEmptyProduct() {
        return new Product();
    }

}
