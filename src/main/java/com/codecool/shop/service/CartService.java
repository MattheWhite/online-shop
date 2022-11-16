package com.codecool.shop.service;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;

public class CartService {
    private CartDao cartDao = CartDaoMem.getInstance();
    private ProductDao productDao = ProductDaoMem.getInstance();
    public void addProductToCart(int id) {
        cartDao.add(productDao.find(id));
    }

    public CartDao getCartDao() {
        return cartDao;
    }
}
