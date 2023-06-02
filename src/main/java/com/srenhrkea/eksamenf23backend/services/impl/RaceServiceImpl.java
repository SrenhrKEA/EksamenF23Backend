package com.srenhrkea.eksamenf23backend.services.impl;

import com.srenhrkea.eksamenf23backend.models.Race;
import com.srenhrkea.eksamenf23backend.repositories.RaceRepository;
import com.srenhrkea.eksamenf23backend.services.RaceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RaceServiceImpl implements RaceService {

  private final RaceRepository raceRepository;

  @Override
  public Race getRaceById(Long id) {
    return raceRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Der blev ikke fundet nogen kapsejlads, der matcher ID'et: " + id));
  }

  @Override
  public List<Race> getAllRaces() {
    return raceRepository.findAll();
  }

  @Override
  public void updateRace(Race requestBody) {
    Race race = raceRepository.findById(requestBody.getRaceId())
        .orElseThrow(() -> new EntityNotFoundException("Der blev ikke fundet nogen kapsejlads, der matcher ID'et: " + requestBody.getRaceId()));
    race.setBoats(requestBody.getBoats());
    raceRepository.save(race);
  }

  @Override
  public void saveRace(Race requestBody) {
    raceRepository.save(requestBody);
  }

  @Override
  public void deleteRace(Race requestBody) {
    raceRepository.delete(requestBody);
  }
}
