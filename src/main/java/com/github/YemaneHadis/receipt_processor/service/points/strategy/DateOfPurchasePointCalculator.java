package com.github.YemaneHadis.receipt_processor.service.points.strategy;

import com.github.YemaneHadis.receipt_processor.model.Receipt;

public class DateOfPurchasePointCalculator implements PointCalculator {

    @Override
    public int calculatePoints(Receipt receipt) {
        return  (receipt.getPurchaseDate().getDayOfMonth() %2 != 0) ? 6:0;
    }

}
