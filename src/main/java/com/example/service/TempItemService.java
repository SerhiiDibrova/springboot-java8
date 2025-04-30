package com.example.service;

import com.example.repository.TempItemRepository;
import com.example.model.TempItem;
import com.example.service.ErrorLogService;

import java.util.ArrayList;
import java.util.List;

public class TempItemService {
    private final TempItemRepository tempItemRepository;
    private final ErrorLogService errorLogService;

    public TempItemService(TempItemRepository tempItemRepository, ErrorLogService errorLogService) {
        this.tempItemRepository = tempItemRepository;
        this.errorLogService = errorLogService;
    }

    public List<TempItem> getTempItemsWithErrorHandling() {
        List<TempItem> tempItems = new ArrayList<>();
        try {
            tempItems = tempItemRepository.findAll();
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            int errorSeverity = 1; // Default severity
            int errorState = 0; // Default state
            errorLogService.logError(errorMessage, errorSeverity, errorState);
        }
        return tempItems != null ? tempItems : new ArrayList<>();
    }
}