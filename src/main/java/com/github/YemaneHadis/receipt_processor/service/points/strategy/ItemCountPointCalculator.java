package com.github.YemaneHadis.receipt_processor.service.points.strategy;

import com.github.YemaneHadis.receipt_processor.model.Receipt;

public class ItemCountPointCalculator implements PointCalculator {

    @Override
    public int calculatePoints(Receipt receipt) {
        // Five Points for every two item
        return (receipt.getItems().size()/2) * 5;
    }
}