package com.jasper.report.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * MarksModel
 *
 * JPA entity representing subject-wise marks
 * obtained by students.
 *
 * This entity links students and subjects
 * and stores academic performance details
 * such as marks, semester, and exam type.
 *
 * Used primarily for generating student
 * performance and result Jasper reports.
 *
 * Mapped to the "marks" table in the database.
 */
@Entity
@Table(name = "marks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarksModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private StudentModel student;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id")
	private SubjectModel subject;

	@Column(nullable = false)
	private Double marksObtained;

	private String semester;

	private String examType;

}