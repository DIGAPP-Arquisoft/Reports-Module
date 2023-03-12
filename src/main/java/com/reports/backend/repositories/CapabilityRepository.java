package com.reports.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reports.backend.entities.Capability;

@Repository
public interface CapabilityRepository extends JpaRepository<Capability, Integer> {

}
