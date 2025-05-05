package hello.service;

import hello.repository.TemporaryItemsRepository;
import hello.dto.DisplayOptionsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemporaryItemsService {

    private static final Logger log = LoggerFactory.getLogger(TemporaryItemsService.class);
    private final TemporaryItemsRepository temporaryItemsRepository;

    public TemporaryItemsService(TemporaryItemsRepository temporaryItemsRepository) {
        this.temporaryItemsRepository = temporaryItemsRepository;
    }

    public List<DisplayOptionsDTO> retrieveDisplayOptions() {
        try {
            return temporaryItemsRepository.executeRetrieveDisplayOptions();
        } catch (Exception e) {
            log.error("Error retrieving display options: " + e.getMessage());
            throw new RuntimeException("Failed to retrieve display options", e);
        }
    }
}