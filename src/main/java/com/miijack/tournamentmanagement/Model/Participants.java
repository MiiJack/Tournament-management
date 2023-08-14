package com.miijack.tournamentmanagement.Model;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Participants {
    private int id;
    private String username;
    private String name;
    private Date birthdate;
    private String team;
}
