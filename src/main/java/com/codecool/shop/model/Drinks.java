package com.codecool.shop.model;

import java.io.Serializable;
import java.util.List;

public class Drinks implements Serializable {
    private List<Product> drinks;

    public List<Product> getDrinks() {
        return drinks;
    }

}