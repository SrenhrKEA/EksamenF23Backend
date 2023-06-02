package com.srenhrkea.eksamenf23backend.services;

import com.srenhrkea.eksamenf23backend.models.Boat;
import com.srenhrkea.eksamenf23backend.models.Race;

import java.util.List;

public interface RaceService {

  Race getRaceById(Long id);

  List<Race> getAllRaces();

  void updateRace(Race boat);

  void saveRace(Race boat);

  void deleteRace(Race boat);
}
