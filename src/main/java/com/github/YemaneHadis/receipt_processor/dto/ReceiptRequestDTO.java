package com.github.YemaneHadis.receipt_processor.dto;

import com.github.YemaneHadis.receipt_processor.model.Item;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @param retailer For now I am only sending bad request 400
 *                 But we can also send 400 bad request and log the error
 *                 to  our logger by using @ControllerAdvice
 */
public record ReceiptRequestDTO(@NotBlank(message = "Retailer Name is Required") String retailer,
                                @NotNull(message = "Purchase date is required") @PastOrPresent(message = "Purchase date must be in the past or today") LocalDate purchaseDate,
                                @NotNull(message = "Purchase time is required") LocalTime purchaseTime,
                                @NotEmpty(message = "Item list can not be empty") List< @Valid ItemDTO> items) {

    public ReceiptRequestDTO(String retailer, LocalDate purchaseDate, LocalTime purchaseTime, List<ItemDTO> items) {
        this.retailer = retailer;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.items = items;
    }
}
