package com.jasper.report.repository;

import com.jasper.report.model.CaterOwnerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CaterOwnerRepository
 *
 * Repository interface for managing CaterOwner entity.
 */
@Repository
public interface CaterOwnerRepository extends JpaRepository<CaterOwnerModel, Long> {
}