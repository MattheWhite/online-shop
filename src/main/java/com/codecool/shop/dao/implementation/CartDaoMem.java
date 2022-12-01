package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartDaoMem implements CartDao {
    private Map<Product, Integer> products;

    private static CartDaoMem instance = null;

    private CartDaoMem() {
        products = new HashMap<>();
    }

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Product product) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + 1);
        }
        products.putIfAbsent(product, 1);
    }

    @Override
    public void remove(Product product) {
        products.replace(product, products.get(product) - 1);
        if (products.get(product) <= 0) {
            products.remove(product);
        }
    }

    @Override
    public Map<Product, Integer> getProducts() {
        return products;
    }

    @Override
    public void removeAll(Product product) {
        products.remove(product);
    }


}
