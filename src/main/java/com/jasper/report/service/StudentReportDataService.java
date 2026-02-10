package com.jasper.report.service;

import com.jasper.report.dto.SemesterStudentReportDTO;
import com.jasper.report.dto.StudentBranchReportDTO;
import com.jasper.report.dto.StudentMarksReportDTO;

import java.util.List;

/**
 * StudentReportDataService
 *
 * Service interface responsible for fetching
 * student-related data required for
 * Jasper report generation.
 */
public interface StudentReportDataService {

	/**
	 * Returns branch-wise student report data.
	 *
	 * @return list of StudentBranchReportDTO
	 */
	List<StudentBranchReportDTO> getBranchWiseStudentData();

	/**
	 * Returns student marks report data.
	 *
	 * @return list of StudentMarksReportDTO
	 */
	List<StudentMarksReportDTO> getStudentMarksData();

	/**
	 * Returns semester-wise student list.
	 *
	 * @return list of SemesterStudentReportDTO
	 */
	List<SemesterStudentReportDTO> getSemesterWiseStudents();

}