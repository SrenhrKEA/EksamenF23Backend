package com.srenhrkea.eksamenf23backend.repositories;

import com.srenhrkea.eksamenf23backend.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {

  List<Score> findAllByBoatBoatId (Long boat_boatId);

  List<Score> findAllByRaceRaceId (Long race_raceId);

  List<Score> findAllByRaceRaceIdAndBoatBoatId (Long race_raceId, Long boat_boatId);
}
