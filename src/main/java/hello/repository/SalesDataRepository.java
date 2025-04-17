

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesDataRepository extends JpaRepository<SalesDataEntity, Long> {

    @Query("SELECT s FROM SalesDataEntity s WHERE s.productName = :productName")
    List<SalesDataEntity> findByProductName(@Param("productName") String productName);

    @Query("SELECT s FROM SalesDataEntity s WHERE s.region = :region")
    List<SalesDataEntity> findByRegion(@Param("region") String region);

    @Query("SELECT s FROM SalesDataEntity s WHERE s.country = :country")
    List<SalesDataEntity> findByCountry(@Param("country") String country);

    @Query("SELECT s FROM SalesDataEntity s WHERE s.productName = :productName AND s.region = :region")
    List<SalesDataEntity> findByProductNameAndRegion(@Param("productName") String productName, @Param("region") String region);

    @Query("SELECT s FROM SalesDataEntity s WHERE s.productName = :productName AND s.country = :country")
    List<SalesDataEntity> findByProductNameAndCountry(@Param("productName") String productName, @Param("country") String country);

    @Query("SELECT s FROM SalesDataEntity s WHERE s.region = :region AND s.country = :country")
    List<SalesDataEntity> findByRegionAndCountry(@Param("region") String region, @Param("country") String country);

    @Query("SELECT s FROM SalesDataEntity s WHERE s.productName = :productName AND s.region = :region AND s.country = :country")
    List<SalesDataEntity> findByProductNameAndRegionAndCountry(@Param("productName") String productName, @Param("region") String region, @Param("country") String country);
}