package com.jasper.report.service.impl;

import com.jasper.report.dto.CaterOwnerReportDTO;
import com.jasper.report.model.CaterOwnerModel;
import com.jasper.report.repository.CaterOwnerRepository;
import com.jasper.report.service.CaterOwnerReportDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * CaterOwnerReportDataServiceImpl
 *
 * Concrete implementation of CaterOwnerReportDataServiceImpl.
 *
 * Responsible for retrieving cater owner data
 * from database and mapping it to DTO format.
 */
@Service
@RequiredArgsConstructor
public class CaterOwnerReportDataServiceImpl implements CaterOwnerReportDataService {

	/**
	 * Repository for accessing cater owner data.
	 */
	private final CaterOwnerRepository caterOwnerRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CaterOwnerReportDTO getOwnerDetails() {
		CaterOwnerModel owner = caterOwnerRepository.findAll()
			.stream()
			.findFirst()
			.orElseThrow(() -> new RuntimeException("Owner not found"));

		return CaterOwnerReportDTO.builder()
			.caterName(owner.getCaterName())
			.mobileNo(owner.getMobileNo())
			.address(owner.getAddress())
			.build();
	}

}