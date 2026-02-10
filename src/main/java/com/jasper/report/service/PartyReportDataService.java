package com.jasper.report.service;

import com.jasper.report.dto.PartyEventReportDTO;
import com.jasper.report.dto.PartyMenuReportDTO;

import java.util.List;

/**
 * PartyReportDataService
 *
 * Service interface responsible for fetching
 * party event and menu data required
 * for Jasper report generation.
 */
public interface PartyReportDataService {

	/**
	 * Fetch single party event details.
	 *
	 * @param eventId unique party event identifier
	 * @return PartyEventReportDTO containing event details
	 */
	PartyEventReportDTO getPartyEventDetails(Long eventId);

	/**
	 * Fetch party menu list.
	 *
	 * @param eventId unique party event identifier
	 * @return list of PartyMenuReportDTO containing menu details
	 */
	List<PartyMenuReportDTO> getPartyMenuDetails(Long eventId);

}