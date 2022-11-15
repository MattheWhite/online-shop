package com.codecool.shop.dao;

import com.codecool.shop.model.Product;

public interface CartDao {
    void add(Product product);
    void remove(Product product);
}
