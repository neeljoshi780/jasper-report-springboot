package com.jasper.report.service;

/**
 * StudentReportExportService
 *
 * Service interface responsible for exporting
 * student-related Jasper reports into PDF format.
 *
 * Acts as the central contract for all
 * student report generation operations.
 */
public interface StudentReportExportService {

	/**
	 * Generates Branch-Semester wise student report PDF.
	 *
	 * @return generated PDF as byte array
	 */
	byte[] generateBranchSemesterReport();

	/**
	 * Generates detailed Student Marks report PDF.
	 *
	 * @return generated PDF as byte array
	 */
	byte[] generateStudentMarksReport();

}