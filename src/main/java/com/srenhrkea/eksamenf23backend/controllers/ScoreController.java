package com.srenhrkea.eksamenf23backend.controllers;

import com.srenhrkea.eksamenf23backend.dtos.ScoreDTO;
import com.srenhrkea.eksamenf23backend.models.Score;
import com.srenhrkea.eksamenf23backend.services.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/score")
public class ScoreController {

  private final ScoreService scoreService;

  @GetMapping("/list")
  public List<Score> returnScores() {
    return scoreService.getAllScores();
  }

  @GetMapping("/list/boat/{boatId}")
  public List<Score> returnScoresByBoat(@PathVariable Long boatId) {
    return scoreService.getScoreByBoatId(boatId);
  }

  @GetMapping("/list/race/{raceId}")
  public List<Score> returnScoresByRace(@PathVariable Long raceId) {
    return scoreService.getScoreByRaceId(raceId);
  }

  @GetMapping("/list/{raceId}&{boatId}")
  public List<Score> returnScoresByRaceAndBoat(@PathVariable Long raceId, @PathVariable Long boatId) {
    return scoreService.getScoreByRaceIdAndBoatId(raceId, boatId);
  }

  @PostMapping("/save")
  public ResponseEntity<String> registerScore(@RequestBody List<ScoreDTO> requestBody) {
    System.out.println(requestBody);
    requestBody
        .forEach(this::processScore);
    return new ResponseEntity<>("Register Complete", HttpStatus.OK);
  }

  private void processScore(ScoreDTO scoreDTO) {
    scoreService.saveScore(scoreDTO);
  }
}
