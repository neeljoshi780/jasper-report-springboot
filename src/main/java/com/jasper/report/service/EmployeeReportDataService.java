package com.jasper.report.service;

import com.jasper.report.dto.EmployeeReportDTO;

import java.util.List;

/**
 * EmployeeReportDataService
 *
 * Service interface responsible for fetching
 * employee report data based on selected language.
 *
 * Handles database-level localization
 * (English / Hindi / Gujarati column selection).
 */
public interface EmployeeReportDataService {

	/**
	 * Fetch employee report records according to language.
	 *
	 * @param language language code ("en", "hi", "gu")
	 * @return localized employee report DTO list
	 */
	List<EmployeeReportDTO> getEmployeeReportData(String language);

}