package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.model.AccountRecord;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AccountRecord, String> {

    List<AccountRecord> findAll();

    Optional<AccountRecord> findById(String id);

    AccountRecord save(AccountRecord accountRecord);

    void deleteById(String id);
}