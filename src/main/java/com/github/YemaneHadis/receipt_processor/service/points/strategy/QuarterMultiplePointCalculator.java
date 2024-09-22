package com.github.YemaneHadis.receipt_processor.service.points.strategy;

import com.github.YemaneHadis.receipt_processor.model.Receipt;

public class QuarterMultiplePointCalculator implements PointCalculator {

    @Override
    public int calculatePoints(Receipt receipt) {
        return receipt.getTotal() %0.25 == 0 ? 25:0;
    }
    // todo where to put the calculation for calculate the total
}