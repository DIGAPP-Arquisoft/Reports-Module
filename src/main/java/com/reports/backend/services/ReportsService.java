package com.reports.backend.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.reports.backend.converters.ReportsConverter;
import com.reports.backend.repositories.ReportsRepository;
import com.reports.backend.data.AvData;
import com.reports.backend.data.ReportsData;
import com.reports.backend.entities.Reports;

@Service
public class ReportsService {
    @Autowired
    private ReportsRepository reportsRepository;

    private final ReportsConverter reportsConverter = new ReportsConverter();

    // List all reports
    public List<Reports> findAll() {
        return reportsRepository.findAll();
    }

    // List report by ID
    public Reports findById(int ReportId) {
        Optional<Reports> report = reportsRepository.findById(ReportId);
        if (report.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The report doesn't exists");
        }
        return report.get();
    }

    // List reports by establishment
    public List<Reports> findByEstablishment(String EstablishmentID) {
        List<Reports> reportsestablishment = reportsRepository.findByestablishmentid(EstablishmentID);
        if (reportsestablishment.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There's no reports for this stablishment");
        }
        return reportsestablishment;
    }

    // Calculate average values
    public AvData getAverage(String EstablishmentID) {
        List<Reports> reportsestablishment = reportsRepository.findByestablishmentid(EstablishmentID);
        if (reportsestablishment.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There's no reports for this establishment");
        }
        BigDecimal InternetAv = new BigDecimal(0.0);
        BigDecimal EstablishmentAv = new BigDecimal(0.0);

        for (Reports report : reportsestablishment) {
            InternetAv = InternetAv.add(report.getInternetquality());
            EstablishmentAv = EstablishmentAv.add(report.getScoreestablishment());
        }
        BigDecimal lenght = new BigDecimal(reportsestablishment.size());
        InternetAv = InternetAv.divide(lenght, 1, RoundingMode.HALF_UP);
        EstablishmentAv = EstablishmentAv.divide(lenght, 1, RoundingMode.HALF_UP);
        AvData averages = new AvData(InternetAv, EstablishmentAv);
        return averages;
    }

    // Add a report
    public Reports insert(ReportsData report) {
        if (reportsRepository.existsById(report.getReportid())) {
            throw new ResponseStatusException(HttpStatus.NOT_MODIFIED, "Report already exists");
        }
        return reportsRepository.save(reportsConverter.toEntity(report));
    }

    // Delete a report
    public Reports deleteById(int id) {
        Optional<Reports> report = reportsRepository.findById(id);
        if (report.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Report doesn't exists!");
        }
        reportsRepository.deleteById(id);
        return report.get();
    }
}
