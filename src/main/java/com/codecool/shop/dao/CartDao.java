package com.codecool.shop.dao;

import com.codecool.shop.model.Product;

import java.util.List;
import java.util.Map;

public interface CartDao {
    void add(Product product);
    void remove(Product product);

    Map<Product, Integer> getProducts();

    void removeAll(Product product);
}
