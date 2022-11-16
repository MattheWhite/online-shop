package com.codecool.shop.model.dto;

import com.codecool.shop.model.Product;

import java.io.Serializable;
import java.util.List;

public class Drinks implements Serializable {

    //TODO: should we put Product + Drinks in the dto package??
    private List<Product> drinks;

    public List<Product> getDrinks() {
        return drinks;
    }

    public int getSize() {
        return drinks.size();
    }

}