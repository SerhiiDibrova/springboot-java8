package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import hello.model.WarehouseData;
import hello.model.TempItems;
import hello.service.WarehouseDataService;
import java.util.List;

@RestController
public class WarehouseDataController {

    @Autowired
    private WarehouseDataService warehouseDataService;

    @PostMapping("/warehouse-data")
    public ResponseEntity<List<WarehouseData>> getWarehouseData(@RequestBody List<TempItems> tempItems) {
        List<WarehouseData> warehouseData = warehouseDataService.retrieveWarehouseData(tempItems);
        return ResponseEntity.ok(warehouseData);
    }
}