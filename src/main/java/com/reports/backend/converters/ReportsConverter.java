package com.reports.backend.converters;

import com.reports.backend.data.ReportsData;
import com.reports.backend.entities.Reports;

public class ReportsConverter extends Converter<Reports, ReportsData> {

    @Override
    public Reports toEntity(ReportsData object) {
        return object == null ? null
                : Reports.builder()
                        .reportid(object.getReportid())
                        .userid(object.getUserid())
                        .establishmentid(object.getEstablishmentid())
                        .date(object.getDate())
                        .scoreestablishment(object.getScoreestablishment())
                        .internetquality(object.getInternetquality())
                        .scorereport(object.getScorereport())
                        .review(object.getReview())
                        .build();
    }

    @Override
    public ReportsData toData(Reports object) {
        return object == null ? null
                : ReportsData.builder()
                        .reportid(object.getReportid())
                        .userid(object.getUserid())
                        .establishmentid(object.getEstablishmentid())
                        .date(object.getDate())
                        .scoreestablishment(object.getScoreestablishment())
                        .internetquality(object.getInternetquality())
                        .scorereport(object.getScorereport())
                        .review(object.getReview())
                        .build();
    }

}
