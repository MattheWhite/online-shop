package com.codecool.shop.config;

import com.codecool.shop.service.APIService;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.dto.Drinks;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

@WebListener
public class Initializer implements ServletContextListener {
    private String url = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        Drinks drinks;
        try {
            drinks = APIService.setupJson(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //setting up a new supplier
//        Supplier amazon = new Supplier("Amazon", "Digital content and services");
//        supplierDataStore.add(amazon);
//        Supplier lenovo = new Supplier("Lenovo", "Computers");
//        supplierDataStore.add(lenovo);

        //setting up a new product category
        ProductCategory alcoholic = new ProductCategory("Alcoholic", "Beverage", "A strong alcoholic drink.");
        productCategoryDataStore.add(alcoholic);
        ProductCategory nonAlcoholic = new ProductCategory("Alcohol free", "Beverage", "Alcohol free drink.");
        productCategoryDataStore.add(nonAlcoholic);
        ProductCategory optionalAlcoholic = new ProductCategory("Optional", "Beverage", "Alcohol free drink, but you can buy alcoholic version");
        productCategoryDataStore.add(optionalAlcoholic);


        Random random = new Random();

        //setting up products and printing it
        for (Product drink:drinks.getDrinks()) {
            if (drink.getCategory().equalsIgnoreCase("Non Alcoholic")) {
                productDataStore.add(new Product(drink.getName(), BigDecimal.valueOf(Math.floor(Math.random() * (60 - 20 + 1) + 20)).setScale(2, RoundingMode.HALF_UP), "GBP", drink.getDescription(), nonAlcoholic, drink.getImagePath()));
            } else if (drink.getCategory().equalsIgnoreCase("Alcoholic")) {
                productDataStore.add(new Product(drink.getName(), BigDecimal.valueOf(Math.floor(Math.random() * (60 - 20 + 1) + 20)).setScale(2, RoundingMode.HALF_UP), "GBP", drink.getDescription(), alcoholic, drink.getImagePath()));
            } else {
                productDataStore.add(new Product(drink.getName(), BigDecimal.valueOf(Math.random() * (60 - 20 + 1) + 20).setScale(2, RoundingMode.HALF_UP), "GBP", drink.getDescription(), optionalAlcoholic, drink.getImagePath()));
            }
        }

//        productDataStore.add(new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
    }
}
