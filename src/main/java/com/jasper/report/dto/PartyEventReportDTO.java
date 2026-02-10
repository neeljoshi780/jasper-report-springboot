package com.jasper.report.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * PartyEventReportDTO
 *
 * Data Transfer Object used for Party Event Jasper report.
 *
 * Represents core event details required for
 * generating the master party report.
 *
 * This DTO is populated using JPQL projection
 * from PartyEventModel and passed to Jasper
 * as a bean data source.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PartyEventReportDTO {

	private Long id;

	private String partyName;

	private String mobileNo;

	private LocalDate eventDate;

	private String eventTime;

	private String venue;

}