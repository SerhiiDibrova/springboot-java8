package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import hello.model.WarehouseData;
import hello.model.TempItem;
import hello.service.GetWarehouseDataService;

@RestController
@RequestMapping("/api")
public class GetWarehouseDataController {

    @Autowired
    private GetWarehouseDataService getWarehouseDataService;

    @PostMapping("/getWarehouseData")
    public ResponseEntity<List<WarehouseData>> getWarehouseData(@RequestBody List<TempItem> tempItems) {
        List<WarehouseData> warehouseData = getWarehouseDataService.getWarehouseData(tempItems);
        return ResponseEntity.ok(warehouseData);
    }
}