package com.srenhrkea.eksamenf23backend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString /*Remember to add ToString.Exclude to lazy fields, https://www.jpa-buddy.com/blog/lombok-and-jpa-what-may-go-wrong/*/
@Table(name = "scores")
public class Score {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "score_id")
  private Long scoreId;

  @ManyToOne
  @JoinColumn(name = "boat_id")
  private Boat boat;

  @ManyToOne
  @JoinColumn(name = "race_id")
  private Race race;

  private int position;

  private int points;

  private Boolean notStarted;

  private Boolean falseStart;

  private Boolean notFinished;
}
