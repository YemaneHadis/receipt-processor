package com.github.YemaneHadis.receipt_processor.controller;


import com.github.YemaneHadis.receipt_processor.dto.PointDTO;
import com.github.YemaneHadis.receipt_processor.dto.ReceiptRequestDTO;
import com.github.YemaneHadis.receipt_processor.dto.ReceiptResponseDTO;
import com.github.YemaneHadis.receipt_processor.exception.ReceiptNotFoundException;
import com.github.YemaneHadis.receipt_processor.repository.ReceiptRepository;
import com.github.YemaneHadis.receipt_processor.service.points.ReceiptService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {


    private  final ReceiptService receiptService;

    public ReceiptController(ReceiptRepository receiptRepository, ReceiptService receiptService){
        this.receiptService = receiptService;
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<PointDTO> findById(@PathVariable("id")  @NotBlank String id) throws ReceiptNotFoundException{
        PointDTO pointDTO = new PointDTO(receiptService.calculatePoints(id));
        return ResponseEntity.ok(pointDTO);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<ReceiptResponseDTO> save(@Valid @RequestBody ReceiptRequestDTO receiptRequestDTO){
        return ResponseEntity.ok(receiptService.save(receiptRequestDTO));
    }

}
