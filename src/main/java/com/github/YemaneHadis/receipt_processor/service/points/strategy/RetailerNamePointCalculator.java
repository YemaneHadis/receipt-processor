package com.github.YemaneHadis.receipt_processor.service.points.strategy;

import com.github.YemaneHadis.receipt_processor.model.Receipt;

public class RetailerNamePointCalculator implements PointCalculator {

    @Override
    public int calculatePoints(Receipt receipt) {
        return  receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "").length();
    }
}