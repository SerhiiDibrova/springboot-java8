package hello.service;

import hello.dto.TempItemDTO;
import hello.entity.TempItem;
import hello.exception.CustomException;
import hello.repository.TempItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class TempItemService {

    private final TempItemRepository tempItemRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public TempItemService(TempItemRepository tempItemRepository) {
        this.tempItemRepository = tempItemRepository;
    }

    @Transactional
    public void insertTempItems(TempItemDTO tempItemDTO) {
        if (tempItemDTO == null || tempItemDTO.getField1() == null || tempItemDTO.getField2() < 0 || tempItemDTO.getField3() == null || tempItemDTO.getField4().length() > 255) {
            throw new CustomException("Invalid input data");
        }
        TempItem tempItem = new TempItem();
        tempItem.setField1(tempItemDTO.getField1());
        tempItem.setField2(tempItemDTO.getField2());
        tempItem.setField3(tempItemDTO.getField3());
        tempItem.setField4(tempItemDTO.getField4());
        tempItemRepository.save(tempItem);
    }

    @Transactional
    public void generateTempItems() {
        String sql = "CREATE TEMPORARY TABLE TempItems AS SELECT * FROM Orders"; 
        Query query = entityManager.createNativeQuery(sql);
        query.executeUpdate();
    }

    public List<Object[]> retrieveDisplayOptions() {
        try {
            String sql1 = "SELECT DISTINCT * FROM TempItems t JOIN CustomConfig c ON t.order_id = c.order_id JOIN DisplayOptions d ON c.config_id = d.config_id WHERE c.module = 'SALES'";
            String sql2 = "SELECT DISTINCT * FROM TempItems t JOIN LegacyConfig l ON t.order_id = l.order_id JOIN DisplayOptions d ON l.config_id = d.config_id WHERE l.module = 'MARKETING_DATA'";
            Query query1 = entityManager.createNativeQuery(sql1);
            Query query2 = entityManager.createNativeQuery(sql2);
            List<Object[]> results1 = query1.getResultList();
            List<Object[]> results2 = query2.getResultList();
            results1.addAll(results2);
            return results1;
        } catch (Exception e) {
            throw new CustomException("Error retrieving display options", e);
        }
    }
}