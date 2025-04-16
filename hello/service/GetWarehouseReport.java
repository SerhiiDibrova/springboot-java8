

package hello.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetWarehouseReport {

    public List<String> getWarehouseReport() {
        List<String> report = new ArrayList<>();
        report.add("Warehouse Report:");
        report.add("Total Sales: $1000");
        report.add("Top Selling Product: Product A");
        report.add("Lowest Selling Product: Product C");
        return report;
    }
}