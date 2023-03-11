package com.reports.backend.converters;

import com.reports.backend.data.ReportsData;
import com.reports.backend.entities.Reports;

public class ReportsConverter extends Converter<Reports, ReportsData> {

    @Override
    public Reports toEntity(ReportsData object) {
        return object == null ? null
                : Reports.builder()
                        .ReportID(object.getReportID())
                        .USER_UserID(object.getUSER_UserID())
                        .ESTABLISHMENT_EstablishmentID(object.getESTABLISHMENT_EstablishmentID())
                        .date(object.getDate())
                        .ScoreEstablishment(object.getScoreEstablishment())
                        .InternetQuality(object.getInternetQuality())
                        .ScoreReport(object.getScoreReport())
                        .CAPABILITY_capabilityID(object.getCAPABILITY_capabilityID())
                        .build();
    }

    @Override
    public ReportsData toData(Reports object) {
        return object == null ? null
                : ReportsData.builder()
                        .ReportID(object.getReportID())
                        .USER_UserID(object.getUSER_UserID())
                        .ESTABLISHMENT_EstablishmentID(object.getESTABLISHMENT_EstablishmentID())
                        .date(object.getDate())
                        .ScoreEstablishment(object.getScoreEstablishment())
                        .InternetQuality(object.getInternetQuality())
                        .ScoreReport(object.getScoreReport())
                        .CAPABILITY_capabilityID(object.getCAPABILITY_capabilityID())
                        .build();
    }

}
