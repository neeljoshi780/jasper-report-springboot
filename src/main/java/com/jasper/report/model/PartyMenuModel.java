package com.jasper.report.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * PartyMenuModel
 *
 * JPA entity representing menu details
 * associated with a party event.
 *
 * Each record defines a specific menu section
 * including event timing and food categories
 * such as drinks, bites, and lunch.
 *
 * Linked to PartyEventModel through a
 * many-to-one relationship.
 *
 * Mapped to the "party_menu" table in the database.
 */
@Entity
@Table(name = "party_menu")
@Getter
@Setter
public class PartyMenuModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "TEXT")
	String sectionTitle;

	@Column(name = "start_date")
	private LocalDate startDate;

	@Column(name = "start_time")
	private String startTime;

	@Column(columnDefinition = "TEXT")
	private String drinks;

	@Column(columnDefinition = "TEXT")
	private String bites;

	@Column(columnDefinition = "TEXT")
	private String lunch;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_id")
	private PartyEventModel partyEvent;

}