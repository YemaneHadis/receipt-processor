package com.github.YemaneHadis.receipt_processor.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


public record ItemDTO(
        @NotBlank(message = "Item description is required" ) String shortDescription,
        @Min(value = 0, message = "Negative Value are not allowed") double price) {
}
