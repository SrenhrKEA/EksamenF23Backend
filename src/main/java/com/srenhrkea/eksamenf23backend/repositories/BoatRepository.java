package com.srenhrkea.eksamenf23backend.repositories;

import com.srenhrkea.eksamenf23backend.enums.BoatClassification;
import com.srenhrkea.eksamenf23backend.models.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Long> {

  List<Boat> findBoatByClassification (BoatClassification classification);
}
