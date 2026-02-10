package com.jasper.report.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * StudentMarksReportDTO
 *
 * Data Transfer Object used for generating
 * detailed Student Marks Jasper reports.
 *
 * Represents subject-wise academic performance
 * of a student including branch, semester,
 * and examination details.
 *
 * This DTO is populated using JPQL projection
 * from MarksModel and related entities.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentMarksReportDTO {

	private String studentName;

	private String rollNo;

	private String branchName;

	private String subjectName;

	private double maxMarks;

	private double marksObtained;

	private String semester;

	private String examType;

}