package com.github.YemaneHadis.receipt_processor.service.points;

import com.github.YemaneHadis.receipt_processor.dto.ReceiptRequestDTO;
import com.github.YemaneHadis.receipt_processor.dto.ReceiptResponseDTO;
import com.github.YemaneHadis.receipt_processor.exception.ReceiptNotFoundException;
import com.github.YemaneHadis.receipt_processor.helper.ItemMapperUtil;
import com.github.YemaneHadis.receipt_processor.model.Receipt;
import com.github.YemaneHadis.receipt_processor.repository.ReceiptRepository;
import com.github.YemaneHadis.receipt_processor.service.points.strategy.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ReceiptService {

    ReceiptRepository receiptRepository;
    public ReceiptService(ReceiptRepository receiptRepository){
        this.receiptRepository  = receiptRepository;
    }

    public int calculatePoints(String id) throws ReceiptNotFoundException {

        /*
         * Used Strategy pattern so we will not have the concrete
         * Implementation of calculating points in here and we can
         * add if there is New way of calculating points
        */

        Receipt receipt = receiptRepository.findById(id);

        List<PointCalculator> calculators  = Arrays.asList(
                new RetailerNamePointCalculator(),
                new RoundDollarPointCalculator(),
                new QuarterMultiplePointCalculator(),
                new ItemCountPointCalculator(),
                new ItemDescriptionPointCalculator(),
                new DateOfPurchasePointCalculator(),
                new TimeOfPurchasePointCalculator()
        );

        PointsContext context = new PointsContext(calculators);
        return  context.calculateTotalPoints(receipt);

    }

    public ReceiptResponseDTO save(ReceiptRequestDTO receiptRequestDTO) {
        String uuid = UUID.randomUUID().toString();
        Receipt receipt = new Receipt(
                uuid,
                receiptRequestDTO.retailer(),
                receiptRequestDTO.purchaseDate(),
                receiptRequestDTO.purchaseTime(),
                ItemMapperUtil.itemDTOMapper(receiptRequestDTO.items()));
        Receipt savedReceipt = receiptRepository.save(receipt);
        return new ReceiptResponseDTO(savedReceipt.getId());
    }






}
