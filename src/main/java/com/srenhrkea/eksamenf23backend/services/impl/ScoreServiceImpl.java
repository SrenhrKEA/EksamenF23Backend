package com.srenhrkea.eksamenf23backend.services.impl;

import com.srenhrkea.eksamenf23backend.dtos.ScoreDTO;
import com.srenhrkea.eksamenf23backend.models.Score;
import com.srenhrkea.eksamenf23backend.repositories.BoatRepository;
import com.srenhrkea.eksamenf23backend.repositories.RaceRepository;
import com.srenhrkea.eksamenf23backend.repositories.ScoreRepository;
import com.srenhrkea.eksamenf23backend.services.ScoreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {

  private final ScoreRepository scoreRepository;
  private final RaceRepository raceRepository;
  private final BoatRepository boatRepository;

  @Override
  public Score getScoreById(Long id) {
    return scoreRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Der blev ikke fundet nogen score, der matcher ID'et: " + id));
  }

  @Override
  public List<Score> getAllScores() {
    return scoreRepository.findAll();
  }

  @Override
  public List<Score> getScoreByBoatId(Long boatId) {
    return scoreRepository.findAllByBoatBoatId(boatId);
  }

  @Override
  public List<Score> getScoreByRaceId(Long raceId) {
    return scoreRepository.findAllByRaceRaceId(raceId);
  }

  @Override
  public List<Score> getScoreByRaceIdAndBoatId(Long raceId, Long boatId) {
    return scoreRepository.findAllByRaceRaceIdAndBoatBoatId(boatId, raceId);
  }

  @Override
  public void updateScore(Score score) {

  }

  @Override
  public void saveScore(ScoreDTO scoreDTO) {
    Score score = new Score();
    score.setBoat(boatRepository.findById(scoreDTO.getBoatId())
        .orElseThrow(() -> new EntityNotFoundException("Der blev ikke fundet nogen båd, der matcher ID'et: " + scoreDTO.getBoatId())));

    score.setRace(raceRepository.findById(scoreDTO.getRaceId()).orElseThrow(() -> new EntityNotFoundException("Der blev ikke fundet nogen kapsejlads, der matcher ID'et: " + scoreDTO.getRaceId())));

    score.setPosition(scoreDTO.getPosition());
    score.setNotStarted(scoreDTO.getNotStarted());
    score.setFalseStart(scoreDTO.getFalseStart());
    score.setNotFinished(scoreDTO.getNotFinished());

    int pointsResult = calculatePoints(scoreDTO.getPosition(), scoreDTO.getNotStarted(), scoreDTO.getFalseStart(), scoreDTO.getNotFinished());
    score.setPoints(pointsResult);
    scoreRepository.save(score);
  }

  @Override
  public void deleteScore(Score score) {
    scoreRepository.delete(score);
  }

  @Override
  public int calculatePoints(int position, boolean notStarted, boolean falseStart, boolean notFinished) {
    int result = position;
    if (notStarted)
      result = result + 2;
    else if (falseStart)
      result = result + 1;
    else if (notFinished)
      result = result + 1;
    return result;
  }
}
