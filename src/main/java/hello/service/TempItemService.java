package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.TempItemRepository;
import hello.model.TempItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class TempItemService {

    private final TempItemRepository tempItemRepository;
    private static final Logger logger = LoggerFactory.getLogger(TempItemService.class);

    @Autowired
    public TempItemService(TempItemRepository tempItemRepository) {
        this.tempItemRepository = tempItemRepository;
    }

    public List<TempItem> getAllTempItems() {
        logger.info("Fetching all temp items");
        return tempItemRepository.findAll();
    }

    public TempItem getTempItemById(Long id) {
        logger.info("Fetching temp item with id: {}", id);
        return tempItemRepository.findById(id).orElse(null);
    }

    public TempItem createTempItem(TempItem tempItem) {
        validateTempItem(tempItem);
        logger.info("Creating temp item: {}", tempItem);
        return tempItemRepository.save(tempItem);
    }

    public TempItem updateTempItem(Long id, TempItem tempItem) {
        validateTempItem(tempItem);
        if (tempItemRepository.existsById(id)) {
            tempItem.setId(id);
            logger.info("Updating temp item with id: {}", id);
            return tempItemRepository.save(tempItem);
        }
        logger.warn("Temp item with id: {} not found for update", id);
        return null;
    }

    public void deleteTempItem(Long id) {
        if (tempItemRepository.existsById(id)) {
            logger.info("Deleting temp item with id: {}", id);
            tempItemRepository.deleteById(id);
        } else {
            logger.warn("Temp item with id: {} not found for deletion", id);
        }
    }

    private void validateTempItem(TempItem tempItem) {
        if (tempItem == null || tempItem.getName() == null || tempItem.getName().isEmpty()) {
            throw new IllegalArgumentException("TempItem name must not be null or empty");
        }
    }
}