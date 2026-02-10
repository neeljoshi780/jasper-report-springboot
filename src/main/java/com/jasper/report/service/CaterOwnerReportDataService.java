package com.jasper.report.service;

import com.jasper.report.dto.CaterOwnerReportDTO;

/**
 * CaterOwnerReportDataService
 *
 * Service interface for fetching cater owner
 * details required for Jasper report generation.
 */
public interface CaterOwnerReportDataService {

	/**
	 * Retrieves cater owner information
	 * for Party report.
	 *
	 * @return CaterOwnerReportDTO containing owner details
	 */
	CaterOwnerReportDTO getOwnerDetails();

}