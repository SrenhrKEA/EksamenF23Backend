package com.srenhrkea.eksamenf23backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.srenhrkea.eksamenf23backend.enums.BoatClassification;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString /*Remember to add ToString.Exclude to lazy fields, https://www.jpa-buddy.com/blog/lombok-and-jpa-what-may-go-wrong/*/
@Table(name = "boats")
public class Boat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "boat_id")
  private Long boatId;

  private String name;

  private double length;

  @Enumerated(EnumType.ORDINAL)
  private BoatClassification classification;

  @ManyToMany(mappedBy = "boats")
  @ToString.Exclude
  @JsonIgnore
  private Set<Race> races;

  @OneToMany(mappedBy = "boat")
  @JsonIgnore
  private Set<Score> scores;
}
