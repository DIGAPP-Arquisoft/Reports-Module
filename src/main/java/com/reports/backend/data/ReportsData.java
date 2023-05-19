package com.reports.backend.data;

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
    private int reportid;
    private int userid;
    private int establishmentid;
    private Date date;
    private BigDecimal internetquality;
    private BigDecimal scoreestablishment;
    private BigDecimal scorereport;
    private String review;
}
