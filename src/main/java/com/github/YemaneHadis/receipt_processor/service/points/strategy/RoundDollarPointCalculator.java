package com.github.YemaneHadis.receipt_processor.service.points.strategy;

import com.github.YemaneHadis.receipt_processor.model.Receipt;

public class RoundDollarPointCalculator implements PointCalculator {

    @Override
    public int calculatePoints(Receipt receipt) {
        return receipt.getTotal() % 1 == 0 ? 50:0;
    }
}