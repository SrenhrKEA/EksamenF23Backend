package com.srenhrkea.eksamenf23backend.repositories;

import com.srenhrkea.eksamenf23backend.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
}
