package com.github.YemaneHadis.receipt_processor.service.points.strategy;

import com.github.YemaneHadis.receipt_processor.model.Item;
import com.github.YemaneHadis.receipt_processor.model.Receipt;

public class ItemDescriptionPointCalculator implements PointCalculator {

    @Override
    public int calculatePoints(Receipt receipt) {
        int point = 0;
        for (Item item : receipt.getItems()){
            int trimmedLength = item.getShortDescription().trim().length();
            if ( trimmedLength % 3 == 0){
                point +=  (int) Math.ceil(item.getPrice() * 0.2);
            }
        }
        return point;
    }
}