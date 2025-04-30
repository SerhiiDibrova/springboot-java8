package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface TempItemRepository extends JpaRepository<TempItem, Long> {
    @Override
    List<TempItem> findAll();

    List<TempItem> findBySomeField(@Param("value") String value);
}