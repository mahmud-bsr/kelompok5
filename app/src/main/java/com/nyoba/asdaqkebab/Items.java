package com.nyoba.asdaqkebab;

public class Items {
    private String name;
    private int quantity;
    private int price;

    public Items(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName() {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity() {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
