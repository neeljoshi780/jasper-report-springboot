package com.jasper.report.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * StudentBranchReportDTO
 *
 * Data Transfer Object used for branch-wise
 * student reporting in Jasper reports.
 *
 * Represents student name along with
 * associated branch/department name.
 *
 * This DTO is populated using JPQL projection
 * and used as the main dataset in
 * branch-based student reports.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentBranchReportDTO {

	private String studentName;

	private String branchName;

}