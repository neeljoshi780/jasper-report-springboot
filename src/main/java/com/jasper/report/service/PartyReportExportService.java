package com.jasper.report.service;

/**
 * PartyReportExportService
 *
 * Service interface responsible for generating
 * complete Party Jasper reports in PDF format.
 */
public interface PartyReportExportService {

	/**
	 * Generates full Party Report PDF.
	 *
	 * @param eventId unique party event identifier
	 * @return generated PDF as byte array
	 */
	byte[] generatePartyReport(Long eventId);

}