package com.miijack.tournamentmanagement.model;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Participant {
    private int id;
    private String username;
    private String name;
    private Date birthdate;
    private String team;
}
