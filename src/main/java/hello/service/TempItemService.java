package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hello.repository.CustomConfigRepository;
import hello.repository.LegacyConfigRepository;
import hello.repository.DisplayOptionsRepository;
import hello.model.TempItem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TempItemService {

    @Autowired
    private CustomConfigRepository customConfigRepository;

    @Autowired
    private LegacyConfigRepository legacyConfigRepository;

    @Autowired
    private DisplayOptionsRepository displayOptionsRepository;

    @Transactional
    public List<TempItem> createTemporaryTableAndRetrieveData() {
        try {
            customConfigRepository.createTemporaryTable();
            List<TempItem> salesData = customConfigRepository.getSalesData();
            List<TempItem> marketingData = legacyConfigRepository.getMarketingData();
            List<TempItem> displayOptions = displayOptionsRepository.getDisplayOptions();

            return combineResults(salesData, marketingData, displayOptions);
        } catch (Exception e) {
            throw new RuntimeException("Error while processing temporary items: " + e.getMessage(), e);
        }
    }

    private List<TempItem> combineResults(List<TempItem> salesData, List<TempItem> marketingData, List<TempItem> displayOptions) {
        Set<TempItem> uniqueItems = new HashSet<>();
        uniqueItems.addAll(salesData);
        uniqueItems.addAll(marketingData);
        uniqueItems.addAll(displayOptions);
        return List.copyOf(uniqueItems);
    }
}