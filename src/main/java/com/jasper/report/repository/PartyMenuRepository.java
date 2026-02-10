package com.jasper.report.repository;

import com.jasper.report.dto.PartyMenuReportDTO;
import com.jasper.report.model.PartyMenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PartyMenuRepository
 *
 * Repository interface for managing PartyMenuModel entity.
 *
 * Provides custom JPQL projection query used
 * for retrieving menu details associated with
 * a specific party event for Jasper report generation.
 *
 * Extends JpaRepository to inherit standard
 * CRUD database operations.
 */
@Repository
public interface PartyMenuRepository extends JpaRepository<PartyMenuModel, Long> {

	/**
	 * Fetch party menu details by event ID.
	 */
	@Query("""
		SELECT new com.jasper.report.dto.PartyMenuReportDTO(
			m.id,
			m.sectionTitle,
			m.startDate,
			m.startTime,
			m.drinks,
			m.bites,
			m.lunch
		)
		FROM PartyMenuModel m
		WHERE m.partyEvent.id = :eventId
		ORDER BY m.id
	""")
	List<PartyMenuReportDTO> getPartyMenuReport(@Param("eventId") Long eventId);

}