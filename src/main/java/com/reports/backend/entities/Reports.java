package com.reports.backend.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Reports {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ReportID;

    @Column(nullable = false)
    private int USER_UserID;

    @Column(nullable = false)
    private int ESTABLISHMENT_EstablishmentID;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false, precision = 2, scale = 1)
    private BigDecimal InternetQuality;

    @Column(nullable = false, precision = 2, scale = 1)
    private BigDecimal ScoreEstablishment;

    @Column(nullable = false, precision = 2, scale = 1)
    private BigDecimal ScoreReport;

    @Column(nullable = false, length = 280)
    private String Review;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    private Capability CAPABILITY_capabilityID;
}
