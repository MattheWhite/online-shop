package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class CartDaoMem implements CartDao {
    private List<Product> products;
    private static CartDaoMem instance = null;

    private CartDaoMem() {
        products = new ArrayList<>();
    }

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void remove(Product product) {
        products.remove(product);

    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
