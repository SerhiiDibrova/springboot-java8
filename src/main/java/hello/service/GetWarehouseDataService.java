package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.GetWarehouseDataRepository;
import hello.model.TempItemsModel;
import hello.model.WarehouseDataDTO;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class GetWarehouseDataService {

    private static final Logger logger = LoggerFactory.getLogger(GetWarehouseDataService.class);

    @Autowired
    private GetWarehouseDataRepository repository;

    public List<WarehouseDataDTO> getWarehouseData(List<TempItemsModel> tempItems) {
        if (tempItems == null || tempItems.isEmpty()) {
            return List.of();
        }

        try {
            return repository.findWarehouseDataByItemIds(tempItems.stream()
                .map(TempItemsModel::getItemId)
                .toList());
        } catch (DataAccessException e) {
            logger.error("Error retrieving warehouse data", e);
            throw new CustomDataAccessException("Error retrieving warehouse data", e);
        }
    }
}