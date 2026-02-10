package com.jasper.report.service.impl;

import com.jasper.report.dto.CaterOwnerReportDTO;
import com.jasper.report.dto.PartyEventReportDTO;
import com.jasper.report.dto.PartyMenuReportDTO;
import com.jasper.report.service.CaterOwnerReportDataService;
import com.jasper.report.service.PartyReportDataService;
import com.jasper.report.service.PartyReportExportService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PartyReportExportServiceImpl
 *
 * Concrete implementation of PartyReportExportService.
 *
 * Responsible for loading master Jasper template,
 * preparing multiple sub-datasets,
 * applying dynamic parameters,
 * and exporting the final Party report as PDF.
 */
@Service
@RequiredArgsConstructor
public class PartyReportExportServiceImpl implements PartyReportExportService {

	/**
	 * Service for fetching party event and menu data.
	 */
	private final PartyReportDataService partyReportDataService;

	/**
	 * Service for fetching cater owner data.
	 */
	private final CaterOwnerReportDataService caterOwnerReportDataService;

	/**
	 * Loads compiled master Jasper report from classpath.
	 *
	 * @return JasperReport instance
	 */
	private JasperReport loadReport() {
		try {
			InputStream is = new ClassPathResource("reports/cater_report_master.jasper").getInputStream();
			return (JasperReport) JRLoader.loadObject(is);
		} catch (Exception ex) {
			throw new RuntimeException("Report load failed", ex);
		}
	}

	/**
	 * Fills Jasper report and exports as PDF.
	 *
	 * @param report master Jasper template
	 * @param params report parameters
	 * @param ds empty data source for master report
	 * @return generated PDF bytes
	 */
	private byte[] exportPdf(JasperReport report, Map<String, Object> params, JREmptyDataSource ds) {
		try {
			JasperPrint jp = JasperFillManager.fillReport(report, params, ds);
			return JasperExportManager.exportReportToPdf(jp);
		} catch (Exception ex) {
			throw new RuntimeException("PDF generation failed", ex);
		}
	}

	/**
	 * Builds common static parameters required
	 * for Party master report including images
	 * and dynamic label values.
	 *
	 * @return parameter map
	 */
	private Map<String, Object> buildCommonParams() {
		Map<String, Object> params = new HashMap<>();

		params.put("BG1", "reports/images/BG1.jpeg");
		params.put("BG2", "reports/images/BG2.jpeg");
		params.put("BG3", "reports/images/BG3.jpeg");
		params.put("BG4", "reports/images/BG4.jpeg");
		params.put("BG5", "reports/images/BG5.jpeg");

		params.put("VECTOR1", "reports/images/VECTOR1.png");
		params.put("VECTOR2", "reports/images/VECTOR2.png");
		params.put("VECTOR3", "reports/images/VECTOR3.png");

		// Dynamic party detail labels
		params.put("P_LABEL_PARTY_NAME", "Party Name");
		params.put("P_LABEL_MOBILE_NO", "Mobile No.");
		params.put("P_LABEL_EVENT_DATE", "Event Date");
		params.put("P_LABEL_EVENT_TIME", "Event Time");
		params.put("P_LABEL_VENUE", "Venue");

		// Dynamic menu detail labels
		params.put("P_LABEL_START_EVENT_DATE", "Start Date");
		params.put("P_LABEL_START_EVENT_TIME", "Start Time");
		params.put("P_LABEL_DRINKS", "Welcome Drinks");
		params.put("P_LABEL_BITES", "BITTING");
		params.put("P_LABEL_LUNCH", "LUNCH");
		return params;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte[] generatePartyReport(Long eventId) {
		// Party Details
		PartyEventReportDTO party = partyReportDataService.getPartyEventDetails(eventId);
		JRBeanCollectionDataSource partyDS = new JRBeanCollectionDataSource(List.of(party));
		// Menu Details
		List<PartyMenuReportDTO> menuList = partyReportDataService.getPartyMenuDetails(eventId);
		JRBeanCollectionDataSource menuDS = new JRBeanCollectionDataSource(menuList);
		// Owner Details
		CaterOwnerReportDTO ownerDTO = caterOwnerReportDataService.getOwnerDetails();
		JRBeanCollectionDataSource ownerDS = new JRBeanCollectionDataSource(List.of(ownerDTO));

		JasperReport master = loadReport();
		Map<String, Object> params = buildCommonParams();

		params.put("PARTY_DETAILS_DS", partyDS);
		params.put("MENU_DETAILS_DS", menuDS);
		params.put("OWNER_DETAILS_DS", ownerDS);
		return exportPdf(master, params, new JREmptyDataSource(1));
	}

}