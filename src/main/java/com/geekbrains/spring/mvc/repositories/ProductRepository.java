package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    private Long ai = 0L;

    public List<Product> getAll() {
        return Collections.unmodifiableList(products);
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
    }


    public Product save(Product data) {
        validate(data);
        if(data.getId() != null) {
            return update(data);
        } else {
            add(data);
        }
        return data;
    }

    public Product get(Long id) {
        Product result = products.stream()
                .filter(product -> id == product.getId())
                .findAny()
                .orElse(null);
        return result;
    }


    public boolean remove(Long id) {
        return products.removeIf(p -> p.getId().equals(id));
    }

    private Product update(Product data) {
        Product product = get(data.getId());

        if(product != null) {
            product.setTitle(data.getTitle());
            product.setCost(data.getCost());
            return product;
        }
        return null;
    }

    private void validate(Product data) {
        if(data.getTitle() == null || data.getCost() == null) {
            throw new IllegalArgumentException("Product fields cannot be null");
        }

        if(data.getCost() < 0) {
            throw new IllegalArgumentException("Product cost cannot be negative");
        }

        if(data.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Product title cannot be empty");
        }
    }

    private void add(Product product) {
        ai++;
        product.setId(ai);
        products.add(product);
    }

}
