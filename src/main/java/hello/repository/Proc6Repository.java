

package hello.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import hello.entity.Proc6Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface Proc6RecordRepository extends CrudRepository<Proc6Record, Long>, JpaRepository<Proc6Record, Long> {

    @Query("SELECT p FROM Proc6Record p WHERE p.id = :id")
    Proc6Record findById(@Param("id") Long id);

    @Query("SELECT p FROM Proc6Record p WHERE p.name = :name")
    Proc6Record findByName(@Param("name") String name);

    @Query("SELECT p FROM Proc6Record p WHERE p.description = :description")
    Proc6Record findByDescription(@Param("description") String description);

    @Query("SELECT p FROM Proc6Record p WHERE p.status = :status")
    Proc6Record findByStatus(@Param("status") String status);

    @Query("SELECT p FROM Proc6Record p WHERE p.createdAt = :createdAt")
    Proc6Record findByCreatedAt(@Param("createdAt") Date createdAt);

    @Query("SELECT p FROM Proc6Record p WHERE p.updatedAt = :updatedAt")
    Proc6Record findByUpdatedAt(@Param("updatedAt") Date updatedAt);

    @Query("SELECT p FROM Proc6Record p WHERE p.deletedAt = :deletedAt")
    Proc6Record findByDeletedAt(@Param("deletedAt") Date deletedAt);

    @Query("SELECT p FROM Proc6Record p WHERE p.createdBy = :createdBy")
    Proc6Record findByCreatedBy(@Param("createdBy") String createdBy);

    @Query("SELECT p FROM Proc6Record p")
    List<Proc6Record> findAll();

    @Query("SELECT p FROM Proc6Record p WHERE p.id IN :ids")
    List<Proc6Record> findAllByIds(@Param("ids") List<Long> ids);

    @Query("SELECT p FROM Proc6Record p WHERE p.name IN :names")
    List<Proc6Record> findAllByNames(@Param("names") List<String> names);

    @Query("SELECT p FROM Proc6Record p WHERE p.description IN :descriptions")
    List<Proc6Record> findAllByDescriptions(@Param("descriptions") List<String> descriptions);

    @Query("SELECT p FROM Proc6Record p WHERE p.status IN :statuses")
    List<Proc6Record> findAllByStatuses(@Param("statuses") List<String> statuses);

    @Query("SELECT p FROM Proc6Record p WHERE p.createdAt IN :createdDates")
    List<Proc6Record> findAllByCreatedDates(@Param("createdDates") List<Date> createdDates);

    @Query("SELECT p FROM Proc6Record p WHERE p.updatedAt IN :updatedDates")
    List<Proc6Record> findAllByUpdatedDates(@Param("updatedDates") List<Date> updatedDates);

    @Query("SELECT p FROM Proc6Record p WHERE p.deletedAt IN :deletedDates")
    List<Proc6Record> findAllByDeletedDates(@Param("deletedDates") List<Date> deletedDates);

    @Query("SELECT p FROM Proc6Record p WHERE p.createdBy IN :createdBies")
    List<Proc6Record> findAllByCreatedBies(@Param("createdBies") List<String> createdBies);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.id = :id")
    void deleteById(@Param("id") Long id);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.name = :name")
    void deleteByName(@Param("name") String name);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.description = :description")
    void deleteByDescription(@Param("description") String description);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.status = :status")
    void deleteByStatus(@Param("status") String status);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.createdAt = :createdAt")
    void deleteByCreatedAt(@Param("createdAt") Date createdAt);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.updatedAt = :updatedAt")
    void deleteByUpdatedAt(@Param("updatedAt") Date updatedAt);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.deletedAt = :deletedAt")
    void deleteByDeletedAt(@Param("deletedAt") Date deletedAt);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.createdBy = :createdBy")
    void deleteByCreatedBy(@Param("createdBy") String createdBy);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.id IN :ids")
    void deleteAllByIds(@Param("ids") List<Long> ids);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.name IN :names")
    void deleteAllByNames(@Param("names") List<String> names);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.description IN :descriptions")
    void deleteAllByDescriptions(@Param("descriptions") List<String> descriptions);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.status IN :statuses")
    void deleteAllByStatuses(@Param("statuses") List<String> statuses);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.createdAt IN :createdDates")
    void deleteAllByCreatedDates(@Param("createdDates") List<Date> createdDates);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.updatedAt IN :updatedDates")
    void deleteAllByUpdatedDates(@Param("updatedDates") List<Date> updatedDates);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.deletedAt IN :deletedDates")
    void deleteAllByDeletedDates(@Param("deletedDates") List<Date> deletedDates);

    @Modifying
    @Query("DELETE FROM Proc6Record p WHERE p.createdBy IN :createdBies")
    void deleteAllByCreatedBies(@Param("createdBies") List<String> createdBies);
}