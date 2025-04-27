package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TempItemsService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private MarketingDataRepository marketingDataRepository;

    public Set<DisplayOption> retrieveDisplayOptions() {
        Set<DisplayOption> uniqueOptions = new HashSet<>();
        try {
            List<DisplayOption> salesOptions = salesRepository.findAll();
            List<DisplayOption> marketingOptions = marketingDataRepository.findAll();
            uniqueOptions.addAll(salesOptions);
            uniqueOptions.addAll(marketingOptions);
        } catch (Exception e) {
            // Handle error appropriately
        }
        return uniqueOptions;
    }
}