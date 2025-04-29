package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TempItemsService {

    @Autowired
    private CustomConfigRepository customConfigRepository;

    @Autowired
    private LegacyConfigRepository legacyConfigRepository;

    @Autowired
    private DisplayOptionsRepository displayOptionsRepository;

    public List<DisplayOptionsDTO> retrieveDisplayOptions() {
        List<DisplayOptions> salesOptions = getDisplayOptionsForSales();
        List<DisplayOptions> marketingOptions = getDisplayOptionsForMarketingData();
        Set<DisplayOptions> uniqueOptions = new HashSet<>(salesOptions);
        uniqueOptions.addAll(marketingOptions);
        return uniqueOptions.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private List<DisplayOptions> getDisplayOptionsForSales() {
        try {
            return displayOptionsRepository.findSalesOptionsWithJoin();
        } catch (Exception e) {
            // Handle error for missing tables or columns
            return List.of();
        }
    }

    private List<DisplayOptions> getDisplayOptionsForMarketingData() {
        try {
            return displayOptionsRepository.findMarketingOptionsWithJoin();
        } catch (Exception e) {
            // Handle error for missing tables or columns
            return List.of();
        }
    }

    private DisplayOptionsDTO convertToDTO(DisplayOptions displayOptions) {
        DisplayOptionsDTO dto = new DisplayOptionsDTO();
        dto.setId(displayOptions.getId());
        dto.setName(displayOptions.getName());
        dto.setDescription(displayOptions.getDescription());
        return dto;
    }
}