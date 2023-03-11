package com.reports.backend.data;

import com.reports.backend.entities.Capability;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportsData {
    private int ReportID;
    private int USER_UserID;
    private int ESTABLISHMENT_EstablishmentID;
    private Date date;
    private BigDecimal InternetQuality;
    private BigDecimal ScoreEstablishment;
    private BigDecimal ScoreReport;
    private String Review;
    private Capability CAPABILITY_capabilityID;
}
