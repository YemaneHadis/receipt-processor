package com.github.YemaneHadis.receipt_processor.service.points.strategy;

import com.github.YemaneHadis.receipt_processor.model.Receipt;

public interface PointCalculator {
    int calculatePoints(Receipt receipt);
}
