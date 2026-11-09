package com.seuprojeto.mvpfeira.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class Product {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private Double price; // Double como objeto permite valor null ("Sem preço")
    private int stock;
    private String unit;
    private boolean isAvailable;

    public Product(String name, Double price, int stock, String unit, boolean isAvailable) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.unit = unit;
        this.isAvailable = isAvailable;
    }

    // Getters e Setters obrigatórios para o Room
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}