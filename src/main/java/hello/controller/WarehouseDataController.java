package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WarehouseDataController {

    @Autowired
    private WarehouseDataService warehouseDataService;

    @PostMapping("/warehouse-data")
    public ResponseEntity<List<WarehouseData>> getWarehouseData(@RequestBody List<TempItemDTO> tempItems) {
        try {
            List<WarehouseData> warehouseDataList = warehouseDataService.getWarehouseData(tempItems);
            return ResponseEntity.ok(warehouseDataList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}