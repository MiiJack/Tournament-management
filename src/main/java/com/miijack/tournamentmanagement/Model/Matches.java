package com.miijack.tournamentmanagement.Model;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Matches {
    private int id;
    private int tournament_id;
    private int participant1_id;
    private int participant2_id;
    private Timestamp matchDate;
    private int participant1_score;
    private int participant2_score;
    private int round;
}
