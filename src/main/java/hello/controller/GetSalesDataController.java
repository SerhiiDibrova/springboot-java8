package hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import hello.service.GetSalesDataService;
import hello.model.SalesDataDTO;

import java.util.List;

@RestController
public class GetSalesDataController {

    @Autowired
    private GetSalesDataService getSalesDataService;

    @GetMapping("/api/salesdata")
    public List<SalesDataDTO> getSalesData(@RequestParam String order_id, @RequestParam String TempItems) {
        return getSalesDataService.fetchSalesData(order_id, TempItems);
    }
}