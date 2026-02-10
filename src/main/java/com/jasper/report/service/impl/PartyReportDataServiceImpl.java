package com.jasper.report.service.impl;

import com.jasper.report.dto.PartyEventReportDTO;
import com.jasper.report.dto.PartyMenuReportDTO;
import com.jasper.report.repository.PartyEventRepository;
import com.jasper.report.repository.PartyMenuRepository;
import com.jasper.report.service.PartyReportDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PartyReportDataServiceImpl
 *
 * Concrete implementation of PartyReportDataService.
 *
 * Responsible for retrieving party event
 * and menu data from repository layer
 * for Jasper report generation.
 */
@Service
@RequiredArgsConstructor
public class PartyReportDataServiceImpl implements PartyReportDataService {

	/**
	 * Repository for accessing party event data.
	 */
	private final PartyEventRepository partyEventRepository;

	/**
	 * Repository for accessing party menu data.
	 */
	private final PartyMenuRepository partyMenuRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PartyEventReportDTO getPartyEventDetails(Long eventId) {
		return partyEventRepository.getPartyEventReport(eventId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PartyMenuReportDTO> getPartyMenuDetails(Long eventId) {
		return partyMenuRepository.getPartyMenuReport(eventId);
	}

}