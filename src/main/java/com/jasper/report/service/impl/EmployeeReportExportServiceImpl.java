package com.jasper.report.service.impl;

import com.jasper.report.dto.EmployeeReportDTO;
import com.jasper.report.service.EmployeeReportDataService;
import com.jasper.report.service.EmployeeReportExportService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * EmployeeReportExportServiceImpl
 *
 * Concrete implementation of EmployeeReportExportService.
 *
 * Responsible for loading Jasper templates,
 * preparing localized parameters,
 * and exporting employee reports as PDF.
 */
@Service
@RequiredArgsConstructor
public class EmployeeReportExportServiceImpl implements EmployeeReportExportService {

	/**
	 * Service for fetching localized employee data.
	 */
	private final EmployeeReportDataService employeeReportDataService;

	/**
	 * Loads compiled Jasper report file from classpath.
	 *
	 * @return JasperReport instance
	 */
	private JasperReport loadReport() {
		try {
			InputStream inputStream = new ClassPathResource("reports/employee_i18n_report.jasper").getInputStream();
			return (JasperReport) JRLoader.loadObject(inputStream);
		} catch (Exception ex) {
			throw new RuntimeException("Failed to load report: reports/employee_i18n_report.jasper", ex);
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
			throw new RuntimeException("Employee PDF generation failed", ex);
		}
	}

	/**
	 * Builds common Jasper parameters
	 * shared across all supported languages.
	 *
	 * @param locale report locale (controls i18n labels)
	 * @param language custom language code (controls font selection)
	 * @return parameter map
	 */
	private Map<String, Object> commonParams(Locale locale, String language) {
		Map<String, Object> params = new HashMap<>();
		params.put(JRParameter.REPORT_LOCALE, locale);
		params.put("LANG", language);
		return params;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte[] generateEmployeeReport(String language) {
		Locale locale = (language.equals("hi") || language.equals("gu")) ? new Locale(language) : Locale.ENGLISH;
		List<EmployeeReportDTO> employeeList = employeeReportDataService.getEmployeeReportData(language);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employeeList);
		JasperReport report = loadReport();
		Map<String, Object> params = commonParams(locale, language);
		return exportPdf(report, params, dataSource);
	}

}