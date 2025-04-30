package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DisplayOptionsService {

    private final TempItemService tempItemService;
    private static final Logger logger = LoggerFactory.getLogger(DisplayOptionsService.class);

    @Autowired
    public DisplayOptionsService(TempItemService tempItemService) {
        this.tempItemService = tempItemService;
    }

    public Set<String> getDisplayOptions(String module) {
        Set<String> displayOptions = new HashSet<>();
        try {
            if ("SALES".equals(module)) {
                List<String> salesOptions = tempItemService.getSalesDisplayOptions();
                displayOptions.addAll(salesOptions);
            } else if ("MARKETING_DATA".equals(module)) {
                List<String> marketingOptions = tempItemService.getMarketingDisplayOptions();
                displayOptions.addAll(marketingOptions);
            } else {
                logger.error("Invalid module: {}", module);
                throw new IllegalArgumentException("Invalid module: " + module);
            }
        } catch (Exception e) {
            logger.error("Error retrieving display options for module: {}", module, e);
            return new HashSet<>();
        }
        return displayOptions;
    }
}