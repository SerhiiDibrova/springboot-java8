package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.entity.CardRecord;

@Repository
public interface CardRecordRepository extends JpaRepository<CardRecord, Long> {
}