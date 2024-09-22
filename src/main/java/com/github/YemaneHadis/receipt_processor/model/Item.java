package com.github.YemaneHadis.receipt_processor.model;

public class Item {

    String shortDescription;
    double price;

    public String getShortDescription() {
        return shortDescription;
    }

    public double getPrice() {
        return price;
    }

    public Item(String shortDescription, double price) {
        this.shortDescription = shortDescription;
        this.price = price;
    }
}
