package com.example.controller;

import com.example.service.TempItemService;
import com.example.model.TempItem;
import com.example.service.ErrorLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temp-items")
public class TempItemController {

    private final TempItemService tempItemService;
    private final ErrorLogService errorLogService;

    public TempItemController(TempItemService tempItemService, ErrorLogService errorLogService) {
        this.tempItemService = tempItemService;
        this.errorLogService = errorLogService;
    }

    @GetMapping
    public ResponseEntity<List<TempItem>> getTempItems() {
        try {
            List<TempItem> tempItems = tempItemService.getTempItemsWithErrorHandling();
            return ResponseEntity.ok(tempItems);
        } catch (Exception e) {
            errorLogService.logError(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}