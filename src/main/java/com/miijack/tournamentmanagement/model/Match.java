package com.miijack.tournamentmanagement.model;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Match {
    private long id;
    private Tournament tournament_id;
    private Participant participant1_id;
    private Participant participant2_id;
    private Timestamp match_date;
    private int participant1_score;
    private int participant2_score;
    private int round;
}
