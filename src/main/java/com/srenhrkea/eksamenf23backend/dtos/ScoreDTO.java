package com.srenhrkea.eksamenf23backend.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ScoreDTO {

  private Long raceId;
  private Long boatId;
  private int position;
  private Boolean notStarted;
  private Boolean falseStart;
  private Boolean notFinished;

}
