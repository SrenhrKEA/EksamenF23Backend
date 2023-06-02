package com.srenhrkea.eksamenf23backend.controllers;

import com.srenhrkea.eksamenf23backend.enums.BoatClassification;
import com.srenhrkea.eksamenf23backend.models.Boat;
import com.srenhrkea.eksamenf23backend.services.BoatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/boat")
public class BoatController {

  private final BoatService boatService;

  @GetMapping("/list")
  public List<Boat> returnBoats() {
    return boatService.getAllBoats();
  }

  @GetMapping("/list/{classification}")
  public List<Boat> returnBoatsByClassification(@PathVariable String classification) {
    System.out.println("Classification: " + classification);
    return boatService.getBoatsByClassification(BoatClassification.valueOf(classification));
  }

  @PostMapping("/register")
  public ResponseEntity<String> registerBoat(@RequestBody Boat requestBody) {
    boatService.saveBoat(requestBody);
    return new ResponseEntity<>("Register Complete", HttpStatus.OK);
  }

  @PostMapping("/edit")
  public ResponseEntity<String> editBoat(@RequestBody Boat requestBody) {
    boatService.updateBoat(requestBody);
    return new ResponseEntity<>("Update Complete", HttpStatus.OK);
  }

  @PostMapping("/delete")
  public ResponseEntity<String> deleteBoat(@RequestBody Boat requestBody) {
    boatService.deleteBoat(requestBody);
    return new ResponseEntity<>("Delete Complete", HttpStatus.OK);
  }

}
