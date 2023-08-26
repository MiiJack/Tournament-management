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
    private long tournament_id;
    private long participant1_id;
    private long participant2_id;
    private Timestamp match_date;
    private int participant1_score;
    private int participant2_score;
    private int round;
}
