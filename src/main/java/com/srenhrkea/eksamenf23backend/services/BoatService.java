package com.srenhrkea.eksamenf23backend.services;

import com.srenhrkea.eksamenf23backend.enums.BoatClassification;
import com.srenhrkea.eksamenf23backend.models.Boat;

import java.util.List;

public interface BoatService {

  Boat getBoatById(Long id);

  List<Boat> getAllBoats();

  List<Boat> getBoatsByClassification (BoatClassification classification);

  void updateBoat(Boat boat);

  void saveBoat(Boat boat);

  void deleteBoat(Boat boat);
}
