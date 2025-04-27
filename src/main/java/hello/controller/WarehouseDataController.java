package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import hello.service.WarehouseDataService;
import hello.dto.WarehouseDataDTO;
import hello.dto.TempItemsDTO;
import java.util.List;

@RestController
public class WarehouseDataController {

    @Autowired
    private WarehouseDataService warehouseDataService;

    @GetMapping("/warehouse-data")
    public ResponseEntity<List<WarehouseDataDTO>> getWarehouseData(@RequestParam List<TempItemsDTO> tempItems) {
        List<WarehouseDataDTO> warehouseData = warehouseDataService.getWarehouseData(tempItems);
        return ResponseEntity.ok(warehouseData);
    }
}