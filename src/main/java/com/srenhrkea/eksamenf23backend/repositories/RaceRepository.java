package com.srenhrkea.eksamenf23backend.repositories;

import com.srenhrkea.eksamenf23backend.models.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
}
