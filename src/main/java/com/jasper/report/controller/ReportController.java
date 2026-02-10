package com.jasper.report.controller;

import com.jasper.report.service.EmployeeReportExportService;
import com.jasper.report.service.PartyReportExportService;
import com.jasper.report.service.StudentReportExportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * ReportController
 *
 * REST controller responsible for handling Jasper report
 * generation APIs for different report modules.
 *
 * Exposes endpoints to generate PDF reports for:
 * - Student Branch & Semester Report
 * - Student Marks Detail Report
 * - Employee Master Report (i18n supported)
 * - Party Event Master Report (with sub-datasets)
 *
 * All endpoints return generated reports as PDF byte streams.
 */
@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

	/**
	 * Service responsible for generating
	 * student-related Jasper reports.
	 */
	private final StudentReportExportService reportService;

	/**
	 * Service responsible for generating
	 * employee report PDFs with language support.
	 */
	private final EmployeeReportExportService employeeReportService;

	/**
	 * Service responsible for generating
	 * party master report PDFs including
	 * event, menu, and owner details.
	 */
	private final PartyReportExportService partyReportExportService;

	/**
	 * Generates Branch-Semester wise student report PDF.
	 *
	 * @return PDF file containing branch and semester grouped data
	 */
	@GetMapping("/branch-semester")
	public ResponseEntity<byte[]> branchSemesterReport() {
		byte[] pdf = reportService.generateBranchSemesterReport();
		return ResponseEntity.ok()
			.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=branch_semester_report.pdf")
			.contentType(MediaType.APPLICATION_PDF)
			.body(pdf);
	}

	/**
	 * Generates detailed student marks report PDF.
	 *
	 * @return PDF file containing subject-wise student performance data
	 */
	@GetMapping("/marks")
	public ResponseEntity<byte[]> marksReport() {
		byte[] pdf = reportService.generateStudentMarksReport();
		return ResponseEntity.ok()
			.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=marks_report.pdf")
			.contentType(MediaType.APPLICATION_PDF)
			.body(pdf);
	}

	/**
	 * Generates Employee Master Report PDF based on selected language.
	 *
	 * Supported language codes:
	 * - "en" → English
	 * - "hi" → Hindi
	 * - "gu" → Gujarati
	 *
	 * @param lang language code (default: "en")
	 * @return localized employee report PDF
	 */
	@GetMapping("/employee")
	public ResponseEntity<byte[]> employeeReport(@RequestParam(defaultValue = "en") String lang) {
		lang = lang.toLowerCase();
		byte[] pdf = employeeReportService.generateEmployeeReport(lang);
		return ResponseEntity.ok()
			.header(HttpHeaders.CONTENT_DISPOSITION,"inline; filename=employee_report.pdf")
			.contentType(MediaType.APPLICATION_PDF)
			.body(pdf);
	}

	/**
	 * Generates complete Party Event Report PDF.
	 *
	 * Includes:
	 * - Party event details
	 * - Menu details
	 * - Cater owner details
	 *
	 * @param eventId unique identifier of the party event
	 * @return generated party report PDF
	 */
	@GetMapping("/party/{eventId}")
	public ResponseEntity<byte[]> generatePartyReport(@PathVariable Long eventId) {
		byte[] pdf = partyReportExportService.generatePartyReport(eventId);
		return ResponseEntity.ok()
			.header(HttpHeaders.CONTENT_DISPOSITION,"inline; filename=party-report.pdf")
			.contentType(MediaType.APPLICATION_PDF)
			.body(pdf);
	}

}