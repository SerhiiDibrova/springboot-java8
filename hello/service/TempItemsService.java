package hello.service;

import hello.model.DisplayOptions;
import hello.repository.CustomConfigRepository;
import hello.repository.LegacyConfigRepository;
import hello.repository.TempItemsRepository;
import hello.repository.DisplayOptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TempItemsService {

    private static final Logger logger = LoggerFactory.getLogger(TempItemsService.class);

    @Autowired
    private CustomConfigRepository customConfigRepository;

    @Autowired
    private LegacyConfigRepository legacyConfigRepository;

    @Autowired
    private TempItemsRepository tempItemsRepository;

    @Autowired
    private DisplayOptionsRepository displayOptionsRepository;

    public Set<DisplayOptions> retrieveDisplayOptions() {
        Set<DisplayOptions> uniqueOptions = new HashSet<>();
        try {
            List<DisplayOptions> customOptions = customConfigRepository.findAll();
            List<DisplayOptions> legacyOptions = legacyConfigRepository.findAll();
            if (customOptions != null) {
                uniqueOptions.addAll(customOptions);
            } else {
                logger.warn("Custom options are null");
            }
            if (legacyOptions != null) {
                uniqueOptions.addAll(legacyOptions);
            } else {
                logger.warn("Legacy options are null");
            }
        } catch (Exception e) {
            logger.error("Error retrieving display options", e);
        }
        return uniqueOptions;
    }
}