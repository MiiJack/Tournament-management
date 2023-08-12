package com.miijack.tournamentmanagement.Model;

import java.sql.Timestamp;

public class Matches {
    private Long id;
    private Long tournamentId;
    private Long participant1Id;
    private Long participant2Id;
    private Timestamp matchDate;
    private int participant1Score;
    private int participant2Score;
    private int round;
}
