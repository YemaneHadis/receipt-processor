package com.github.YemaneHadis.receipt_processor.service.points.strategy;

import com.github.YemaneHadis.receipt_processor.model.Receipt;

import java.util.List;

public class PointsContext {

    private final List<PointCalculator> calculators;
    public PointsContext(List<PointCalculator> calculators){
        this.calculators = calculators;
    }

    public int calculateTotalPoints(Receipt receipt){
        int totalPoints = 0;
        for (PointCalculator calculator : calculators){
            totalPoints  += calculator.calculatePoints(receipt);
        }
        return  totalPoints;
    }

}
