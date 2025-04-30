package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.ErrorLog;

public interface ErrorLogRepository extends JpaRepository<ErrorLog, Long> {
}