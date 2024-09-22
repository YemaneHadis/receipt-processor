package com.github.YemaneHadis.receipt_processor.model;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Receipt {
    String id;
    String retailer;
    LocalDate purchaseDate;
    LocalTime purchaseTime;
    List<Item> items;

    public Receipt(String id, String retailer, LocalDate purchaseDate, LocalTime purchaseTime, List<Item> items) {
        this.id = id;
        this.retailer = retailer;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public String getRetailer() {
        return retailer;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public LocalTime getPurchaseTime() {
        return purchaseTime;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotal(){
        return  calculateTotal();
    }


    private double calculateTotal(){
        double totalPrice = 0;
        for (Item item: items){
            totalPrice += item.getPrice();
        }
        totalPrice = Math.round(totalPrice*100);
        totalPrice = totalPrice/100;
        return  totalPrice;

    }

}


