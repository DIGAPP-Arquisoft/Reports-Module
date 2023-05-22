package com.reports.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.reports.backend.services.ReportsService;
import com.reports.backend.data.AvData;
import com.reports.backend.data.ReportsData;
import com.reports.backend.entities.Reports;

@RestController
@RequestMapping(path = "/api/reports")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
public class ReportsController {
    @Autowired
    private ReportsService reportservice;

    // Get all reports
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(reportservice.findAll(), HttpStatus.OK);
    }

    // Get report by ID
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Reports report = reportservice.findById(id);
        if (report == null) {
            return new ResponseEntity<>(new Reports[] {}, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(report, HttpStatus.OK);
        }
    }

    // Get reports by ID establishment
    @GetMapping("/e/{EstablishmentID}")
    public ResponseEntity<?> findByEstablishment(@PathVariable String EstablishmentID) {
        return new ResponseEntity<>(reportservice.findByEstablishment(EstablishmentID), HttpStatus.OK);
    }

    // Get Averages
    @GetMapping("/a/{EstablishmentID}")
    public ResponseEntity<?> getAverages(@PathVariable String EstablishmentID) {
        AvData averages = reportservice.getAverage(EstablishmentID);
        if (averages == null) {
            return new ResponseEntity<>(new AvData[] {}, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(averages, HttpStatus.OK);
        }
    }

    // Add report
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ReportsData report) {
        return new ResponseEntity<>(reportservice.insert(report), HttpStatus.CREATED);
    }

    // Delete report
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(reportservice.deleteById(id), HttpStatus.OK);
    }

}
