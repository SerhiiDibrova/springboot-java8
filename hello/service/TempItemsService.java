package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TempItemsService {

    private static final Logger logger = LoggerFactory.getLogger(TempItemsService.class);

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private MarketingDataRepository marketingDataRepository;

    public Set<DisplayOption> retrieveDisplayOptions() {
        Set<DisplayOption> uniqueOptions = new HashSet<>();
        try {
            List<DisplayOption> salesOptions = salesRepository.findAll();
            List<DisplayOption> marketingOptions = marketingDataRepository.findAll();
            if (salesOptions != null) {
                uniqueOptions.addAll(salesOptions);
            } else {
                logger.warn("Sales options are null");
            }
            if (marketingOptions != null) {
                uniqueOptions.addAll(marketingOptions);
            } else {
                logger.warn("Marketing options are null");
            }
        } catch (Exception e) {
            logger.error("Error retrieving display options", e);
        }
        return uniqueOptions;
    }
}