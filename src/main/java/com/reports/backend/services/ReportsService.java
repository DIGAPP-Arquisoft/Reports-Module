package com.reports.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.reports.backend.converters.ReportsConverter;
import com.reports.backend.repositories.ReportsRepository;
import com.reports.backend.data.ReportsData;
import com.reports.backend.entities.Reports;

@Service
public class ReportsService {
    @Autowired
    private ReportsRepository reportsRepository;

    private final ReportsConverter reportsConverter = new ReportsConverter();

    // List all reports
    public List<ReportsData> findAll() {
        return reportsConverter.toData(reportsRepository.findAll());
    }

    // List reports by establishment
    public List<ReportsData> findByESTABLISHMENT(int EstablishmentID) {
        List<Reports> reportsestablishment = reportsRepository.findByESTABLISHMENT_EstablishmentID(EstablishmentID);
        if (reportsestablishment.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There's no reports for this stablishment");
        }
        return reportsConverter.toData(reportsestablishment);
    }

    // Add a report
    public ReportsData insert(ReportsData report) {
        if (reportsRepository.existsById(report.getReportID())) {
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED, "Report already exists");
        }
        return reportsConverter.toData(reportsRepository.save(reportsConverter.toEntity(report)));
    }

    // delete a report
    public ReportsData deleteById(int id) {
        Optional<Reports> report = reportsRepository.findById(id);
        if (report.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Report doesn't exists!");
        }
        reportsRepository.deleteById(id);
        return reportsConverter.toData(report.get());
    }
}
