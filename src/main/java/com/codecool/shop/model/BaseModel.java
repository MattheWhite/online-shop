package com.codecool.shop.model;


import java.lang.reflect.Field;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.lang.reflect.Field;

public class BaseModel implements Serializable {

    @SerializedName(value = "id", alternate = "idDrink")
    protected int id;

    @SerializedName(value = "name", alternate = "strDrink")
    protected String name;
    @SerializedName(value = "description", alternate = "strInstructions")
    protected String description;

    public BaseModel(String name) {
        this.name = name;
    }

    public BaseModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(this);
                if (value != null) {
                    sb.append(field.getName() + ":" + value + ",");
                }
            } catch (IllegalAccessException e) {

            }
        }
        return sb.toString();
    }

}
