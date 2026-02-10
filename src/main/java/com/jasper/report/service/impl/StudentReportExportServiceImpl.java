package com.jasper.report.service.impl;

import com.jasper.report.dto.SemesterStudentReportDTO;
import com.jasper.report.dto.StudentBranchReportDTO;
import com.jasper.report.dto.StudentMarksReportDTO;
import com.jasper.report.service.StudentReportDataService;
import com.jasper.report.service.StudentReportExportService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * StudentReportExportServiceImpl
 *
 * Concrete implementation of StudentReportExportService.
 *
 * Responsible for loading Jasper templates,
 * preparing report data sources,
 * applying common parameters,
 * and exporting reports as PDF.
 */
@Service
@RequiredArgsConstructor
public class StudentReportExportServiceImpl implements StudentReportExportService {

	/**
	 * Service for fetching student report data.
	 */
	private final StudentReportDataService studentReportDataService;

	/**
	 * Loads Jasper report template from classpath.
	 *
	 * @param reportPath path of compiled .jasper file
	 * @return JasperReport instance
	 */
	private JasperReport loadReport(String reportPath) {
		try {
			InputStream inputStream = new ClassPathResource(reportPath).getInputStream();
			return (JasperReport) JRLoader.loadObject(inputStream);
		} catch (Exception ex) {
			throw new RuntimeException("Failed to load report: " + reportPath, ex);
		}
	}

	/**
	 * Fills Jasper report with data and exports as PDF.
	 *
	 * @param report Jasper template
	 * @param parameters report parameters
	 * @param dataSource report data source
	 * @return generated PDF bytes
	 */
	private byte[] exportPdf(JasperReport report, Map<String, Object> parameters, JRBeanCollectionDataSource dataSource) {
		try {
			JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataSource);
			return JasperExportManager.exportReportToPdf(jasperPrint);
		} catch (Exception ex) {
			throw new RuntimeException("PDF generation failed", ex);
		}
	}

	/**
	 * Builds common parameters shared
	 * across all student Jasper reports.
	 *
	 * @return parameter map
	 */
	private Map<String, Object> commonParams() {
		Map<String, Object> params = new HashMap<>();
		params.put("LOGO_PATH", Paths.get("reports", "images", "logo.jpg").toString());
		return params;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte[] generateBranchSemesterReport() {
		List<StudentBranchReportDTO> branchList = studentReportDataService.getBranchWiseStudentData();
		List<SemesterStudentReportDTO> semesterList = studentReportDataService.getSemesterWiseStudents();
		JRBeanCollectionDataSource mainDS = new JRBeanCollectionDataSource(branchList);
		JasperReport report = loadReport("reports/student_branch_wise_report.jasper");
		Map<String, Object> params = commonParams();
		params.put("SEMESTER_DS", new JRBeanCollectionDataSource(semesterList));
		return exportPdf(report, params, mainDS);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte[] generateStudentMarksReport() {
		List<StudentMarksReportDTO> marksList = studentReportDataService.getStudentMarksData();
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(marksList);
		JasperReport report = loadReport("reports/student_marks_detail_report.jasper");
		return exportPdf(report, commonParams(), dataSource);
	}

}