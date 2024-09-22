package com.github.YemaneHadis.receipt_processor;

import com.github.YemaneHadis.receipt_processor.dto.ItemDTO;
import com.github.YemaneHadis.receipt_processor.exception.ReceiptNotFoundException;
import com.github.YemaneHadis.receipt_processor.helper.ItemMapperUtil;
import com.github.YemaneHadis.receipt_processor.model.Receipt;
import com.github.YemaneHadis.receipt_processor.repository.ReceiptRepository;
import com.github.YemaneHadis.receipt_processor.service.points.ReceiptService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReceiptServiceTest {
    @Mock
    private  ReceiptRepository receiptRepository;

    @InjectMocks
    private ReceiptService receiptService;
    List<ItemDTO> items;
    Receipt receipt;
    String id;
    @BeforeEach
    public  void setUp(){
        id = UUID.randomUUID().toString();
       items = Arrays.asList(
                new ItemDTO("Mountain Dew 12PK", 6.49),
                new ItemDTO("Emils Cheese Pizza", 12.25),
                new ItemDTO("Knorr Creamy Chicken", 1.26),
                new ItemDTO("Doritos Nacho Cheese",3.35),
                new ItemDTO("   Klarbrunn 12-PK 12 FL OZ  ",12.00)
        );
        receipt = new Receipt(
                id,
                "Target",
                LocalDate.parse("2022-01-01"),
                LocalTime.parse("13:01"),
                ItemMapperUtil.itemDTOMapper(items)
        );
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public  void testCalculatePoint() throws ReceiptNotFoundException {
        when(receiptRepository.findById(id)).thenReturn(receipt);
        int totalPoint  = receiptService.calculatePoints(id);
        assertEquals(totalPoint,28);
    }
}
