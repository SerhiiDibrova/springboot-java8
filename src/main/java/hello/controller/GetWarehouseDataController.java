package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import hello.model.TempItemsModel;
import hello.model.WarehouseDataDTO;
import hello.service.GetWarehouseDataService;

@RestController
@RequestMapping("/api")
public class GetWarehouseDataController {

    @Autowired
    private GetWarehouseDataService getWarehouseDataService;

    @PostMapping("/getWarehouseData")
    public ResponseEntity<List<WarehouseDataDTO>> getWarehouseData(@RequestBody List<TempItemsModel> tempItems) {
        if (tempItems == null || tempItems.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        try {
            List<WarehouseDataDTO> warehouseData = getWarehouseDataService.getWarehouseData(tempItems);
            return ResponseEntity.ok(warehouseData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}