package com.jasper.report.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * CaterOwnerModel
 *
 * JPA entity representing cater owner master details.
 *
 * Stores basic information about the catering service owner
 * used in the Party Jasper Report.
 *
 * Mapped to the "cater_owner" table in the database.
 */
@Entity
@Table(name = "cater_owner")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CaterOwnerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "cater_name")
	private String caterName;

	@Column(name = "mobile_no")
	private String mobileNo;

	private String address;

}