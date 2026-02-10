package com.jasper.report.dto;

import lombok.*;

/**
 * CaterOwnerReportDTO
 *
 * Data Transfer Object used for Jasper report generation.
 *
 * Represents cater owner details required in
 * the Party Master Report.
 *
 * This DTO is populated from CaterOwner entity
 * and passed to Jasper as a bean data source.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CaterOwnerReportDTO {

	private String caterName;

	private String mobileNo;

	private String address;

}