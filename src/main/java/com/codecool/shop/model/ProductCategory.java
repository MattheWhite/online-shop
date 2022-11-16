package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory extends BaseModel {
    private String type;
    private List<Product> products;

    public ProductCategory(String name, String type, String description) {
        super(name);
        this.type = type;
        this.products = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public String getCategoryName() {
        return this.getName();
    }

    @Override
    public String toString() {
        return String.format(
                "id: %1$d," +
                        "name: %2$s, " +
                        "department: %3$s, " +
                        "description: %4$s",
                this.id,
                this.name,
                this.type,
                this.description);
    }
}