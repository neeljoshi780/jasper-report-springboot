package com.jasper.report.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * SemesterStudentReportDTO
 *
 * Data Transfer Object used for semester-wise
 * student listing in Jasper reports.
 *
 * Represents a student name mapped to
 * a specific academic semester.
 *
 * This DTO is populated using JPQL projection
 * and typically used as a sub-dataset in
 * branch-semester grouped reports.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SemesterStudentReportDTO {

	private String studentName;

	private String semester;

}