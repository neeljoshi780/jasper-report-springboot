package com.jasper.report.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * EmployeeReportDTO
 *
 * Data Transfer Object used for Jasper Employee Report.
 *
 * Represents localized employee information
 * retrieved from database based on selected language.
 *
 * This DTO is populated using JPQL projection
 * queries and passed to Jasper as a bean data source.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeReportDTO {

	private String name;

	private String department;

	private Double salary;

}