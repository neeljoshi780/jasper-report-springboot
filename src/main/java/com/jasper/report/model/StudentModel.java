package com.jasper.report.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * StudentModel
 *
 * JPA entity representing student master information.
 *
 * Stores core student academic details including
 * roll number, name, and branch association.
 *
 * Linked with BranchModel to identify the
 * department/branch of the student.
 *
 * Mapped to the "student" table in the database.
 */
@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String rollNo;

	@Column(nullable = false)
	private String firstName;

	private String lastName;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_id")
	private BranchModel branch;

}