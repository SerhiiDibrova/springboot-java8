package hello.service;

import hello.model.TempItem;
import hello.model.DisplayOptions;
import hello.repository.TempItemRepository;
import hello.repository.DisplayOptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class TempItemService {

    private final TempItemRepository tempItemRepository;
    private final DisplayOptionsRepository displayOptionsRepository;
    private static final Logger logger = LoggerFactory.getLogger(TempItemService.class);

    @Autowired
    public TempItemService(TempItemRepository tempItemRepository, DisplayOptionsRepository displayOptionsRepository) {
        this.tempItemRepository = tempItemRepository;
        this.displayOptionsRepository = displayOptionsRepository;
    }

    @Transactional
    public TempItem createTempItem(TempItem tempItem) {
        validateTempItem(tempItem);
        try {
            return tempItemRepository.save(tempItem);
        } catch (Exception e) {
            logger.error("Error creating TempItem: {}", e.getMessage());
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public TempItem getTempItemById(Long id) {
        return tempItemRepository.findById(id).orElse(null);
    }

    @Transactional
    public TempItem updateTempItem(Long id, TempItem tempItem) {
        if (!tempItemRepository.existsById(id)) {
            logger.warn("TempItem with id {} not found for update", id);
            return null;
        }
        validateTempItem(tempItem);
        tempItem.setId(id);
        try {
            return tempItemRepository.save(tempItem);
        } catch (Exception e) {
            logger.error("Error updating TempItem: {}", e.getMessage());
            throw e;
        }
    }

    @Transactional
    public void deleteTempItem(Long id) {
        if (!tempItemRepository.existsById(id)) {
            logger.warn("TempItem with id {} not found for deletion", id);
            return;
        }
        try {
            tempItemRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Error deleting TempItem: {}", e.getMessage());
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TempItem> getAllTempItems() {
        return tempItemRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<DisplayOptions> getDisplayOptionsForTempItem(Long tempItemId) {
        return displayOptionsRepository.findByTempItemId(tempItemId);
    }

    private void validateTempItem(TempItem tempItem) {
        if (tempItem == null || tempItem.getName() == null || tempItem.getName().isEmpty()) {
            throw new IllegalArgumentException("TempItem name must not be null or empty");
        }
        // Additional validation logic can be added here
    }
}