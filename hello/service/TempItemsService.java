package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataAccessException;
import java.util.HashSet;
import java.util.Set;

@Service
public class TempItemsService {

    @Autowired
    private CustomConfigRepository customConfigRepository;

    @Autowired
    private LegacyConfigRepository legacyConfigRepository;

    @Autowired
    private DisplayOptionsRepository displayOptionsRepository;

    public Set<DisplayOption> retrieveDisplayOptions() {
        Set<DisplayOption> displayOptions = new HashSet<>();
        try {
            displayOptions.addAll(retrieveSalesDisplayOptions());
            displayOptions.addAll(retrieveMarketingDisplayOptions());
        } catch (DataAccessException e) {
            // Handle error appropriately
        }
        return displayOptions;
    }

    private Set<DisplayOption> retrieveSalesDisplayOptions() {
        return new HashSet<>(displayOptionsRepository.findSalesDisplayOptions());
    }

    private Set<DisplayOption> retrieveMarketingDisplayOptions() {
        return new HashSet<>(customConfigRepository.findMarketingDisplayOptions());
    }
}