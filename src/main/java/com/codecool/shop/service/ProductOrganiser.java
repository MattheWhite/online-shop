package com.codecool.shop.service;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.dto.Drinks;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductOrganiser {

    public static void setUpProducts(ProductDao productDataStore, Drinks drinks, ProductCategory alcoholic,
                                     ProductCategory nonAlcoholic, ProductCategory optionalAlcoholic) {
        for (Product drink : drinks.getDrinks()) {
            if (drink.getCategory().equalsIgnoreCase("Non Alcoholic")) {
                productDataStore.add(new Product(drink.getName(), BigDecimal.valueOf(Math.floor(Math.random() * (60 - 20 + 1) + 20)).setScale(2, RoundingMode.HALF_UP), "GBP", drink.getDescription(), nonAlcoholic, drink.getImagePath()));
            } else if (drink.getCategory().equalsIgnoreCase("Alcoholic")) {
                productDataStore.add(new Product(drink.getName(), BigDecimal.valueOf(Math.floor(Math.random() * (60 - 20 + 1) + 20)).setScale(2, RoundingMode.HALF_UP), "GBP", drink.getDescription(), alcoholic, drink.getImagePath()));
            } else {
                productDataStore.add(new Product(drink.getName(), BigDecimal.valueOf(Math.floor(Math.random() * (60 - 20 + 1) + 20)).setScale(2, RoundingMode.HALF_UP), "GBP", drink.getDescription(), optionalAlcoholic, drink.getImagePath()));
            }
        }
    }
}


