package com.jasper.report.repository;

import com.jasper.report.dto.SemesterStudentReportDTO;
import com.jasper.report.dto.StudentMarksReportDTO;
import com.jasper.report.model.MarksModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MarksRepository
 *
 * Repository interface for managing MarksModel entity.
 *
 * Provides custom JPQL projection queries used
 * for generating student performance Jasper reports.
 *
 * Extends JpaRepository to inherit standard
 * CRUD database operations.
 */
@Repository
public interface MarksRepository extends JpaRepository<MarksModel, Long> {

	/**
	 * Returns student marks data.
	 */
	@Query("""
		SELECT new com.jasper.report.dto.StudentMarksReportDTO(
			CONCAT(s.firstName, ' ', COALESCE(s.lastName,'')),
			s.rollNo,
			b.branchName,
			sub.subjectName,
			sub.maxMarks,
			m.marksObtained,
			m.semester,
			m.examType
		)
		FROM MarksModel m
		JOIN m.student s
		JOIN s.branch b
		JOIN m.subject sub
		ORDER BY s.rollNo ASC, m.semester ASC, sub.subjectName ASC
	""")
	List<StudentMarksReportDTO> getStudentMarksData();

	/**
	 * Returns semester-wise student list.
	 */
	@Query("""
		SELECT new com.jasper.report.dto.SemesterStudentReportDTO(
			CONCAT(s.firstName, ' ', s.lastName),
			m.semester
		)
		FROM MarksModel m
		JOIN m.student s
		GROUP BY s.id, s.firstName, s.lastName, m.semester
		ORDER BY m.semester ASC, s.firstName ASC
	""")
	List<SemesterStudentReportDTO> getSemesterWiseStudents();

}