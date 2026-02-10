package com.jasper.report.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * BranchModel
 *
 * JPA entity representing branch (department) master data.
 *
 * This entity is used to categorize students
 * based on their academic branch/department.
 *
 * Mapped to the "branch" table in the database.
 */
@Entity
@Table(name = "branch")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String branchName;

}