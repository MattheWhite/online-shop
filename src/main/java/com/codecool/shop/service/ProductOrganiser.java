package com.codecool.shop.service;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Drinks;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.math.BigDecimal;

public class ProductOrganiser {

    public static void setUpProducts(ProductDao productDataStore, Drinks drinks, ProductCategory alcoholic,
                                     ProductCategory nonAlcoholic, ProductCategory optionalAlcoholic) {
        for (Product drink: drinks.getDrinks()
        ) {
            if (drink.getCategory().equalsIgnoreCase("Non Alcoholic")) {
                productDataStore.add(new Product(drink.getName(), new BigDecimal(String.format(
                        "%.2f", Math.floor(Math.random()*(60-20+1)+20))),
                        "GBP", drink.getDescription(), nonAlcoholic, drink.getImagePath()));
            } else if (drink.getCategory().equalsIgnoreCase("Alcoholic")) {
                productDataStore.add(new Product(drink.getName(), new BigDecimal(String.format(
                        "%.2f", Math.floor(Math.random()*(60-20+1)+20))),
                        "GBP", drink.getDescription(), alcoholic, drink.getImagePath()));
            } else {
                productDataStore.add(new Product(drink.getName(), new BigDecimal(String.format(
                        "%.2f", Math.floor(Math.random()*(60-20+1)+20))),
                        "GBP", drink.getDescription(), optionalAlcoholic, drink.getImagePath()));
            }
        }
    }
}
