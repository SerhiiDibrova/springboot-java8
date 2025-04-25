package hello.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import hello.service.WarehouseDataService;
import hello.model.TempItem;
import hello.model.WarehouseDataResponse;

import java.util.List;

@RestController
public class WarehouseDataController {

    private final WarehouseDataService warehouseDataService;

    public WarehouseDataController(WarehouseDataService warehouseDataService) {
        this.warehouseDataService = warehouseDataService;
    }

    @PostMapping("/warehouse-data")
    public ResponseEntity<WarehouseDataResponse> fetchWarehouseData(@RequestBody List<TempItem> tempItems) {
        try {
            WarehouseDataResponse response = warehouseDataService.getWarehouseData(tempItems);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}