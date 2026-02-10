package com.jasper.report.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * PartyEventModel
 *
 * JPA entity representing a party event record.
 *
 * Stores core event details such as party name,
 * contact information, event schedule, and venue.
 *
 * Maintains a one-to-many relationship with
 * PartyMenuModel to represent menu sections
 * associated with the event.
 *
 * Mapped to the "party_event" table in the database.
 */
@Entity
@Table(name = "party_event")
@Getter
@Setter
public class PartyEventModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	String partyName;

	String mobileNo;

	LocalDate eventDate;

	String eventTime;

	String venue;

	@OneToMany(mappedBy = "partyEvent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<PartyMenuModel> menuList;

}