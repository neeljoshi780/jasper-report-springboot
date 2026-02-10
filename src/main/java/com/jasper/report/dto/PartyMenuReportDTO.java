package com.jasper.report.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * PartyMenuReportDTO
 *
 * Data Transfer Object used for Party Menu
 * section in Jasper report generation.
 *
 * Represents detailed menu information
 * associated with a specific party event.
 *
 * This DTO is populated using JPQL projection
 * from PartyMenuModel and passed to Jasper
 * as a sub-dataset data source.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PartyMenuReportDTO {

	private Long id;

	private String sectionTitle;

	private LocalDate startDate;

	private String startTime;

	private String drinks;

	private String bites;

	private String lunch;

}