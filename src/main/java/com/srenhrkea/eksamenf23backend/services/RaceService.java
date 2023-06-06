package com.srenhrkea.eksamenf23backend.services;

import com.srenhrkea.eksamenf23backend.models.Boat;
import com.srenhrkea.eksamenf23backend.models.Race;

import java.util.List;

public interface RaceService {

  Race getRaceById(Long id);

  List<Race> getAllRaces();

  void updateRace(Race race);

  void saveRace(Race race);

  void deleteRace(Race race);
}
