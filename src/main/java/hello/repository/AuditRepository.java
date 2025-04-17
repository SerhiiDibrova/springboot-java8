

package hello.repository;

import hello.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuditRepository extends JpaRepository<Audit, Long> {

    @Query("SELECT a FROM Audit a WHERE a.managerId = :managerId AND a.type = :type")
    List<Audit> findByManagerIdAndType(@Param("managerId") Long managerId, @Param("type") String type);

    @Query("SELECT a FROM Audit a WHERE a.managerId = :managerId")
    List<Audit> findByManagerId(@Param("managerId") Long managerId);

    @Query("SELECT a FROM Audit a WHERE a.type = :type")
    List<Audit> findByType(@Param("type") String type);

    Audit save(Audit audit);

    @Query("INSERT INTO Audit (id, managerId, type) VALUES (:id, :managerId, :type)")
    @Modifying
    void insertAudit(@Param("id") Long id, @Param("managerId") Long managerId, @Param("type") String type);
}