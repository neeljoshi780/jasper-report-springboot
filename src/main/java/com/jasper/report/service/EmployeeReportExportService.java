package com.jasper.report.service;

/**
 * EmployeeReportExportService
 *
 * Service interface responsible for generating
 * Jasper employee report PDFs.
 *
 * Handles locale selection, Jasper parameter
 * preparation, and PDF export process.
 */
public interface EmployeeReportExportService {

	/**
	 * Generates Employee Master Report PDF
	 * based on selected language.
	 *
	 * @param language selected language ("en", "hi", "gu")
	 * @return generated PDF file as byte array
	 */
	byte[] generateEmployeeReport(String language);

}