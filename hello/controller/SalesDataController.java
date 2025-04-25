package hello.controller;

import hello.model.SalesDataResponse;
import hello.model.TempItem;
import hello.service.SalesDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesDataController {

    private final SalesDataService salesDataService;

    @Autowired
    public SalesDataController(SalesDataService salesDataService) {
        this.salesDataService = salesDataService;
    }

    @GetMapping("/{orderId}")
    public SalesDataResponse getSalesData(@PathVariable String orderId) {
        return salesDataService.retrieveSalesData(orderId);
    }
}