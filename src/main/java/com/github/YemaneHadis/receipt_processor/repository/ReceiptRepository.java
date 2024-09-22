package com.github.YemaneHadis.receipt_processor.repository;

import com.github.YemaneHadis.receipt_processor.exception.ReceiptNotFoundException;
import com.github.YemaneHadis.receipt_processor.model.Receipt;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReceiptRepository {

    List<Receipt> receipts = new ArrayList<>();


    public Receipt findById(String id) throws ReceiptNotFoundException{
        return  receipts
                .stream()
                .filter(
                        receipt -> receipt.getId().equals(id)
                ).findFirst()
                .orElseThrow(ReceiptNotFoundException::new);
    }

    public Receipt save(Receipt receipt){
        receipts.add(receipt);
        return  receipt;
    }


}
