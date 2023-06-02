package com.srenhrkea.eksamenf23backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.srenhrkea.eksamenf23backend.enums.BoatClassification;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString /*Remember to add ToString.Exclude to lazy fields, https://www.jpa-buddy.com/blog/lombok-and-jpa-what-may-go-wrong/*/
@Table(name = "races")
public class Race {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "race_id")
  private Long raceId;

  private LocalDate date;

  @Enumerated(EnumType.STRING)
  private BoatClassification classification;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "races_boats",
      joinColumns = @JoinColumn(
          name = "race_id", referencedColumnName = "race_id"),
      inverseJoinColumns = @JoinColumn(
          name = "boat_id", referencedColumnName = "boat_id"))
  @ToString.Exclude
  private Set<Boat> boats;

  @OneToMany(mappedBy = "race")
  @JsonIgnore
  private Set<Score> scores;

}
