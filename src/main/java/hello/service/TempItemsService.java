package hello.service;

import hello.repository.TempItemsRepository;
import hello.dto.DisplayOptionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TempItemsService {

    @Autowired
    private TempItemsRepository tempItemsRepository;

    @Transactional
    public List<DisplayOptionsDTO> retrieveDisplayOptions() {
        tempItemsRepository.createTempItems();
        return tempItemsRepository.retrieveDisplayOptions();
    }
}