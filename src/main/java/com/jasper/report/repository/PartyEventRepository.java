package com.jasper.report.repository;

import com.jasper.report.dto.PartyEventReportDTO;
import com.jasper.report.model.PartyEventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * PartyEventRepository
 *
 * Repository interface for managing PartyEventModel entity.
 *
 * Provides custom JPQL projection query used
 * for generating Party Event Jasper reports.
 *
 * Extends JpaRepository to inherit standard
 * CRUD database operations.
 */
@Repository
public interface PartyEventRepository extends JpaRepository<PartyEventModel, Long> {

	/**
	 * Fetch party event details by event ID.
	 */
	@Query("""
		SELECT new com.jasper.report.dto.PartyEventReportDTO(
			e.id,
			e.partyName,
			e.mobileNo,
			e.eventDate,
			e.eventTime,
			e.venue
		)
		FROM PartyEventModel e
		WHERE e.id = :eventId
	""")
	PartyEventReportDTO getPartyEventReport(@Param("eventId") Long eventId);

}