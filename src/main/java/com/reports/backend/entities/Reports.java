package com.reports.backend.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties("reportid")
public class Reports {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportid;

    @Column(nullable = false)
    private String userid;

    @Column(nullable = false)
    private String establishmentid;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false, precision = 2, scale = 1)
    private BigDecimal internetquality;

    @Column(nullable = false, precision = 2, scale = 1)
    private BigDecimal scoreestablishment;

    @Column(nullable = true, precision = 2, scale = 1)
    private BigDecimal scorereport;

    @Column(nullable = true, length = 280)
    private String review;
}
