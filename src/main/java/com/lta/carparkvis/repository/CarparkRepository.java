package com.lta.carparkvis.repository;

import com.lta.carparkvis.domain.Carpark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarparkRepository extends JpaRepository<Carpark, String> {
} 