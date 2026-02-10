package com.jasper.report.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * SubjectModel
 *
 * JPA entity representing subject master data.
 *
 * Stores subject code, subject name,
 * and maximum marks configuration.
 *
 * Used for mapping subject details
 * in student marks and performance reports.
 *
 * Mapped to the "subject" table in the database.
 */
@Entity
@Table(name = "subject")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String subjectCode;

	@Column(nullable = false)
	private String subjectName;

	private Double maxMarks;

}