package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TempItemService {

    @Autowired
    private TempItemRepository tempItemRepository;

    @Autowired
    private CustomConfigRepository customConfigRepository;

    @Autowired
    private LegacyConfigRepository legacyConfigRepository;

    @Autowired
    private DisplayOptionsRepository displayOptionsRepository;

    public List<DisplayOption> retrieveDisplayOptions() {
        try {
            List<DisplayOption> salesOptions = retrieveSalesOptions();
            List<DisplayOption> marketingOptions = retrieveMarketingOptions();
            Set<DisplayOption> combinedOptions = new HashSet<>(salesOptions);
            combinedOptions.addAll(marketingOptions);
            return combinedOptions.stream().collect(Collectors.toList());
        } catch (Exception e) {
            // Log the exception (logging framework can be used)
            throw new RuntimeException("Error retrieving display options", e);
        }
    }

    private List<DisplayOption> retrieveSalesOptions() {
        return tempItemRepository.findSalesOptions()
                .stream()
                .map(option -> displayOptionsRepository.findById(option.getDisplayOptionId()))
                .collect(Collectors.toList());
    }

    private List<DisplayOption> retrieveMarketingOptions() {
        return tempItemRepository.findMarketingOptions()
                .stream()
                .map(option -> displayOptionsRepository.findById(option.getDisplayOptionId()))
                .collect(Collectors.toList());
    }
}