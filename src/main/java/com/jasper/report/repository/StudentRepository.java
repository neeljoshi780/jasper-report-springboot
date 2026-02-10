package com.jasper.report.repository;

import com.jasper.report.dto.StudentBranchReportDTO;
import com.jasper.report.model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * StudentRepository
 *
 * Repository interface for managing StudentModel entity.
 *
 * Provides custom JPQL projection queries used
 * for generating student-related Jasper reports.
 *
 * Extends JpaRepository to inherit standard
 * CRUD database operations.
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {

	/**
	 * Fetch branch-wise student list data.
	 */
	@Query("""
		SELECT new com.jasper.report.dto.StudentBranchReportDTO(
			CONCAT(s.firstName, ' ', COALESCE(s.lastName,'')),
			b.branchName
		)
		FROM StudentModel s
		JOIN s.branch b
		ORDER BY b.branchName ASC, s.firstName ASC
	""")
	List<StudentBranchReportDTO> getStudentBranchData();

}