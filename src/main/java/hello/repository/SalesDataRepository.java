package hello.repository;

import hello.dto.TempItemDTO;
import hello.entity.SalesData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SalesDataRepository extends JpaRepository<SalesData, Long> {
    Logger logger = LoggerFactory.getLogger(SalesDataRepository.class);

    @Transactional(readOnly = true)
    @Query("SELECT s FROM SalesData s LEFT JOIN s.tempItems t WHERE s.orderId = :orderId AND t IN :tempItems")
    default List<SalesData> findSalesDataByOrderIdAndTempItems(Integer orderId, List<TempItemDTO> tempItems) {
        try {
            return findSalesDataByOrderIdAndTempItemsInternal(orderId, tempItems);
        } catch (DataAccessException e) {
            logger.error("Error retrieving sales data for orderId: {} and tempItems: {}", orderId, tempItems, e);
            throw e;
        }
    }

    @Query("SELECT s FROM SalesData s LEFT JOIN s.tempItems t WHERE s.orderId = :orderId AND t IN :tempItems")
    List<SalesData> findSalesDataByOrderIdAndTempItemsInternal(Integer orderId, List<TempItemDTO> tempItems);
}