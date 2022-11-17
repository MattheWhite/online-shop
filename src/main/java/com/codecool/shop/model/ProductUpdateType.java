package com.codecool.shop.model;

public enum ProductUpdateType {
    INCREMENT("INCREMENT"),
    DECREMENT("DECREMENT");
    private final String type;

    ProductUpdateType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
