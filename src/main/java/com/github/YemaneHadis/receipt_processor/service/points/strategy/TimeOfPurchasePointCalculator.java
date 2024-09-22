package com.github.YemaneHadis.receipt_processor.service.points.strategy;

import com.github.YemaneHadis.receipt_processor.model.Receipt;

import java.time.LocalTime;

public class TimeOfPurchasePointCalculator implements PointCalculator {

    @Override
    public int calculatePoints(Receipt receipt) {
        LocalTime start = LocalTime.of(14,0); // 2:00 PM
        LocalTime end = LocalTime.of(16,0); // 4:00 PM
        if (receipt.getPurchaseTime().isAfter(start) && receipt.getPurchaseTime().isBefore(end)){
            return 20;
        }
        return 0;
    }
}
