package com.jasper.report.service.impl;

import com.jasper.report.dto.SemesterStudentReportDTO;
import com.jasper.report.dto.StudentBranchReportDTO;
import com.jasper.report.dto.StudentMarksReportDTO;
import com.jasper.report.repository.MarksRepository;
import com.jasper.report.repository.StudentRepository;
import com.jasper.report.service.StudentReportDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * StudentReportDataServiceImpl
 *
 * Concrete implementation of StudentReportDataService.
 *
 * Responsible for retrieving student report data
 * from repository layer for Jasper report processing.
 */
@Service
@RequiredArgsConstructor
public class StudentReportDataServiceImpl implements StudentReportDataService {

	/**
	 * Repository for accessing student data.
	 */
	private final StudentRepository studentRepository;

	/**
	 * Repository for accessing marks data.
	 */
	private final MarksRepository marksRepository;

	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<StudentBranchReportDTO> getBranchWiseStudentData() {
		return studentRepository.getStudentBranchData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<StudentMarksReportDTO> getStudentMarksData() {
		return marksRepository.getStudentMarksData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<SemesterStudentReportDTO> getSemesterWiseStudents() {
		return marksRepository.getSemesterWiseStudents();
	}

}