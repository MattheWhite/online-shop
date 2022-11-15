package com.codecool.shop.model;

import java.io.Serializable;
import java.util.List;

public class Drinks implements Serializable {
    private List<BaseModel> drinks;

    public List<BaseModel> getDrinks() {
        return drinks;
    }

}