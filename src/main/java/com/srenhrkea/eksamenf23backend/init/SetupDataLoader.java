package com.srenhrkea.eksamenf23backend.init;

import com.srenhrkea.eksamenf23backend.enums.BoatClassification;
import com.srenhrkea.eksamenf23backend.models.Boat;
import com.srenhrkea.eksamenf23backend.models.Race;
import com.srenhrkea.eksamenf23backend.repositories.RaceRepository;
import com.srenhrkea.eksamenf23backend.services.BoatService;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class SetupDataLoader implements
    ApplicationListener<ContextRefreshedEvent> {

  private final BoatService boatService;

  private final RaceRepository raceRepository;
  private boolean alreadySetup = false;

  @Override
  @Transactional
  public void onApplicationEvent(ContextRefreshedEvent event) {
    if (alreadySetup)
      return;
    Faker faker = new Faker();
    /*Mindste kategori*/
    Boat boat;
    for (int i = 0; i < 4; i++) {
      boat = new Boat();
      boat.setName(faker.name().firstName());
      boat.setLength(faker.number().numberBetween(20, 24));
      boatService.saveBoat(boat);
    }
    /*Mellemste kategori*/
    for (int i = 0; i < 4; i++) {
      boat = new Boat();
      boat.setName(faker.name().firstName());
      boat.setLength(faker.number().numberBetween(25, 44));
      boatService.saveBoat(boat);
    }
    /*Største kategori*/
    for (int i = 0; i < 4; i++) {
      boat = new Boat();
      boat.setName(faker.name().firstName());
      boat.setLength(faker.number().numberBetween(45, 55));
      boatService.saveBoat(boat);
    }

    /*Kapsejladser i hver kategori, fra onsdag fra 1 maj til 1 oktober*/
    LocalDate startDate = LocalDate.of(LocalDate.now().getYear(), 5, 1);
    LocalDate endDate = LocalDate.of(LocalDate.now().getYear(), 10, 1);


    while (startDate.isBefore(endDate)) {
      if (startDate.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
        Race race = new Race();
        race.setDate(startDate);
        race.setClassification(BoatClassification.LessThan25Feet);
        raceRepository.save(race);

        race = new Race();
        race.setDate(startDate);
        race.setClassification(BoatClassification.Between25And40Feet);
        raceRepository.save(race);

        race = new Race();
        race.setDate(startDate);
        race.setClassification(BoatClassification.LongerThan40Feet);
        raceRepository.save(race);
      }
      startDate = startDate.plusDays(1);
    }

    alreadySetup = true;
  }

}
