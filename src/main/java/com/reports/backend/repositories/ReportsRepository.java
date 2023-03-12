package com.reports.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reports.backend.entities.Reports;

@Repository
public interface ReportsRepository extends JpaRepository<Reports, Integer> {
    List<Reports> findByESTABLISHMENT_EstablishmentID(int EstablishmentID);
}
