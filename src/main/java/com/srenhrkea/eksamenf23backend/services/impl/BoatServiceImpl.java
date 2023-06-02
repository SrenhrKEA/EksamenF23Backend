package com.srenhrkea.eksamenf23backend.services.impl;

import com.srenhrkea.eksamenf23backend.enums.BoatClassification;
import com.srenhrkea.eksamenf23backend.models.Boat;
import com.srenhrkea.eksamenf23backend.repositories.BoatRepository;
import com.srenhrkea.eksamenf23backend.services.BoatService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoatServiceImpl implements BoatService {

  private final BoatRepository boatRepository;

  @Override
  public Boat getBoatById(Long id) {
    return boatRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Der blev ikke fundet nogen båd, der matcher ID'et: " + id));
  }

  @Override
  public List<Boat> getAllBoats() {
    return boatRepository.findAll();
  }

  @Override
  public List<Boat> getBoatsByClassification(BoatClassification classification) {
    return boatRepository.findBoatByClassification(classification);
  }

  @Override
  public void updateBoat(Boat requestBody) {
    Boat boat = boatRepository.findById(requestBody.getBoatId())
        .orElseThrow(() -> new EntityNotFoundException("Der blev ikke fundet nogen båd, der matcher ID'et: " + requestBody.getBoatId()));
    boat.setName(requestBody.getName());
    boat.setLength(requestBody.getLength());
    if (requestBody.getLength() < 25)
      boat.setClassification(BoatClassification.LessThan25Feet);
    else if (requestBody.getLength() >= 25 && requestBody.getLength() <= 40)
      boat.setClassification(BoatClassification.Between25And40Feet);
    else
      boat.setClassification(BoatClassification.LongerThan40Feet);
    boatRepository.save(boat);
  }

  @Override
  public void saveBoat(Boat requestBody) {
    if (requestBody.getLength() < 25)
      requestBody.setClassification(BoatClassification.LessThan25Feet);
    else if (requestBody.getLength() >= 25 && requestBody.getLength() <= 40)
      requestBody.setClassification(BoatClassification.Between25And40Feet);
    else
      requestBody.setClassification(BoatClassification.LongerThan40Feet);
    boatRepository.save(requestBody);
  }

  @Override
  public void deleteBoat(Boat requestBody) {
    boatRepository.delete(requestBody);
  }
}
