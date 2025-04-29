package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TempItemRepository extends JpaRepository<TempItem, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO #TempItems (column1, column2, ...) VALUES (:tempItem.column1, :tempItem.column2, ...)", nativeQuery = true)
    void insertTempItem(TempItem tempItem);

    List<TempItem> findByOrderId(Integer orderId);

    @Query("SELECT new hello.dto.DisplayOptionsDTO(option) FROM CustomConfig c JOIN c.displayOptions option")
    List<DisplayOptionsDTO> findDisplayOptionsForSales();

    @Query("SELECT new hello.dto.DisplayOptionsDTO(option) FROM LegacyConfig l JOIN l.displayOptions option")
    List<DisplayOptionsDTO> findDisplayOptionsForMarketingData();
}