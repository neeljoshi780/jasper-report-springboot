package com.jasper.report.repository;

import com.jasper.report.dto.EmployeeReportDTO;
import com.jasper.report.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long> {

	/**
	 * Fetch employee report data in default language (English).
	 */
	@Query("""
	SELECT new com.jasper.report.dto.EmployeeReportDTO(
		e.nameDefaultLang,
		e.deptDefaultLang,
		e.salary
	)
	FROM EmployeeModel e
	""")
	List<EmployeeReportDTO> getEmployeeReportDataEnglish();

	/**
	 * Fetch employee report data in preferred language (Hindi).
	 */
	@Query("""
	SELECT new com.jasper.report.dto.EmployeeReportDTO(
		e.namePreferLang,
		e.deptPreferLang,
		e.salary
	)
	FROM EmployeeModel e
	""")
	List<EmployeeReportDTO> getEmployeeReportDataHindi();

	/**
	 * Fetch employee report data in supportive language (Gujarati).
	 */
	@Query("""
	SELECT new com.jasper.report.dto.EmployeeReportDTO(
		e.nameSupportiveLang,
		e.deptSupportiveLang,
		e.salary
	)
	FROM EmployeeModel e
	""")
	List<EmployeeReportDTO> getEmployeeReportDataGujarati();

}