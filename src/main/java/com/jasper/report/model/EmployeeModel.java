package com.jasper.report.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * EmployeeModel
 *
 * JPA entity representing employee master information.
 *
 * Stores multilingual employee name and department fields
 * to support internationalized (i18n) Jasper reports.
 *
 * Language-specific columns are used dynamically
 * based on selected report locale.
 *
 * Mapped to the "employee" table in the database.
 */
@Entity
@Table(name = "employee")
@Getter
@Setter
public class EmployeeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nameDefaultLang;

	private String namePreferLang;

	private String nameSupportiveLang;

	private String deptDefaultLang;

	private String deptPreferLang;

	private String deptSupportiveLang;

	private Double salary;

}