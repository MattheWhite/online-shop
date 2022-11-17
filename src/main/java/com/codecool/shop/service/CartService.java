package com.codecool.shop.service;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductUpdateType;

import java.util.List;
import java.util.Map;

public class CartService {
    private static final ProductUpdateType INCREMENT = ProductUpdateType.INCREMENT;
    private static final ProductUpdateType DECREMENT = ProductUpdateType.DECREMENT;
    private CartDao cartDao = CartDaoMem.getInstance();
    private ProductDao productDao = ProductDaoMem.getInstance();
    public void addProductToCart(int id) {
        cartDao.add(productDao.find(id));
    }

    public CartDao getCartDao() {
        return cartDao;
    }

    public Map<Product, Integer> getAllProducts() {
        return cartDao.getProducts();
    }

    public void removeProductFromCart(int id) {
        cartDao.removeAll(productDao.find(id));
    }

    public void updateProductState(int id, String incOrDecr) {
        if (incOrDecr.equals(INCREMENT.toString())) {
            cartDao.add(productDao.find(id));
        } else if (incOrDecr.equals(DECREMENT.toString())) {
            cartDao.remove(productDao.find(id));
        }
    }
}
