package com.github.YemaneHadis.receipt_processor;

import com.github.YemaneHadis.receipt_processor.dto.ItemDTO;
import com.github.YemaneHadis.receipt_processor.dto.ReceiptRequestDTO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiptRequestDTOTest {

    private Validator validator;

    @BeforeEach
    public void setUp(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void testValidReceiptRequestDTO(){
        List<ItemDTO> itemDTOS = new ArrayList<>();
        itemDTOS.add(new ItemDTO("Medium Size Shirt", 12));

        ReceiptRequestDTO dto = new ReceiptRequestDTO(
                "Target",
                LocalDate.now(),
                LocalTime.now(),
                itemDTOS
        );

        Set<ConstraintViolation<ReceiptRequestDTO>> violations = validator.validate(dto);
        assertTrue(violations.isEmpty(), "There should not be validation Error");
    }

    @Test
    public void testInvalidReceiptRequestDTO(){
        List<ItemDTO> itemDTO = new ArrayList<>();
        itemDTO.add(new ItemDTO("Medium Size Shirt", 12));
        ReceiptRequestDTO dto = new ReceiptRequestDTO(
                "Target",
                LocalDate.now().plusDays(1),
                LocalTime.now(),
                itemDTO
        );

        Set<ConstraintViolation<ReceiptRequestDTO>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty(), "There should be validation errors");

    }
}
/**
 *  TODO continue using the same logic to test the rest dto validation
 *  I Skipped for now to Complete the basic functionality in Short time
 *
 * **/
