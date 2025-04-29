package hello.service;

import hello.repository.TempItemRepository;
import hello.repository.CustomConfigRepository;
import hello.repository.LegacyConfigRepository;
import hello.model.TempItem;
import hello.model.DisplayOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.dao.DataAccessException;

import java.util.List;

@Service
public class TempItemService {

    @Autowired
    private TempItemRepository tempItemRepository;

    @Autowired
    private CustomConfigRepository customConfigRepository;

    @Autowired
    private LegacyConfigRepository legacyConfigRepository;

    @Transactional
    public void insertTempItem(TempItem tempItem) {
        try {
            tempItemRepository.insert(tempItem);
        } catch (DataAccessException e) {
            // Handle error for missing tables or columns
            throw new RuntimeException("Error inserting TempItem: " + e.getMessage(), e);
        }
    }

    public List<DisplayOption> getDisplayOptions(String module) {
        List<DisplayOption> customConfigOptions;
        List<DisplayOption> legacyConfigOptions;
        try {
            customConfigOptions = customConfigRepository.getDisplayOptions(module);
            legacyConfigOptions = legacyConfigRepository.getDisplayOptions(module);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error retrieving display options: " + e.getMessage(), e);
        }
        customConfigOptions.addAll(legacyConfigOptions);
        return customConfigOptions.stream().distinct().toList();
    }
}