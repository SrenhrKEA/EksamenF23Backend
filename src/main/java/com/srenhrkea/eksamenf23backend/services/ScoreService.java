package com.srenhrkea.eksamenf23backend.services;

import com.srenhrkea.eksamenf23backend.dtos.ScoreDTO;
import com.srenhrkea.eksamenf23backend.models.Score;

import java.util.List;

public interface ScoreService {

  Score getScoreById(Long id);

  List<Score> getAllScores();

  List<Score> getScoreByBoatId(Long boatId);

  List<Score> getScoreByRaceId(Long raceId);

  List<Score> getScoreByRaceIdAndBoatId(Long raceId, Long boatId);

  void updateScore(Score score);

  void saveScore(ScoreDTO scoreDTO);

  void deleteScore(Score score);

  int calculatePoints(int position, boolean notStarted, boolean falseStart, boolean notFinished);

}
