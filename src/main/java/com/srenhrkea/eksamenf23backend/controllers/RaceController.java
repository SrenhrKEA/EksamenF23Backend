package com.srenhrkea.eksamenf23backend.controllers;

import com.srenhrkea.eksamenf23backend.models.Boat;
import com.srenhrkea.eksamenf23backend.models.Race;
import com.srenhrkea.eksamenf23backend.services.BoatService;
import com.srenhrkea.eksamenf23backend.services.RaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/race")
public class RaceController {

  private final RaceService raceService;

  @GetMapping("/list")
  public List<Race> returnRaces() {
    return raceService.getAllRaces();
  }

  @PostMapping("/signup")
  public ResponseEntity<String> signup(@RequestBody Race requestBody) {
    raceService.saveRace(requestBody);
    return new ResponseEntity<>("Register Complete", HttpStatus.OK);
  }

  @PostMapping("/edit")
  public ResponseEntity<String> edit(@RequestBody Race requestBody) {
    raceService.updateRace(requestBody);
    return new ResponseEntity<>("Register Complete", HttpStatus.OK);
  }

  @PostMapping("/withdraw")
  public ResponseEntity<String> withdraw(@RequestBody Race requestBody) {
    raceService.deleteRace(requestBody);
    return new ResponseEntity<>("Delete Complete", HttpStatus.OK);
  }
}
