package com.jasper.report.service.impl;

import com.jasper.report.dto.EmployeeReportDTO;
import com.jasper.report.repository.EmployeeRepository;
import com.jasper.report.service.EmployeeReportDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * EmployeeReportDataServiceImpl
 *
 * Concrete implementation of EmployeeReportDataService.
 *
 * Responsible for retrieving localized employee
 * report data from the repository layer.
 */
@Service
@RequiredArgsConstructor
public class EmployeeReportDataServiceImpl implements EmployeeReportDataService {

	/**
	 * Repository for accessing employee data.
	 */
	private final EmployeeRepository employeeRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EmployeeReportDTO> getEmployeeReportData(String language) {
		return switch (language) {
			case "hi" -> employeeRepository.getEmployeeReportDataHindi();
			case "gu" -> employeeRepository.getEmployeeReportDataGujarati();
			default -> employeeRepository.getEmployeeReportDataEnglish();
		};
	}

}