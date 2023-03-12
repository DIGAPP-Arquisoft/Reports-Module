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
import com.reports.backend.data.ReportsData;

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
        return new ResponseEntity<>(reportservice.findById(id), HttpStatus.OK);
    }

    // Get reports by ID establishment
    @GetMapping("/e/{EstablishmentID}")
    public ResponseEntity<?> findByEstablishment(@PathVariable int EstablishmentID) {
        return new ResponseEntity<>(reportservice.findByEstablishment(EstablishmentID), HttpStatus.OK);
    }

    // Get Averages
    @GetMapping("/a/{EstablishmentID}")
    public ResponseEntity<?> getAverages(@PathVariable int EstablishmentID) {
        return new ResponseEntity<>(reportservice.getAverage(EstablishmentID), HttpStatus.OK);
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
