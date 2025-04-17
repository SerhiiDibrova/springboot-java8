

package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.SalesReport;

public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {

}