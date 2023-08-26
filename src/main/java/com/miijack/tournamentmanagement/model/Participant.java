package com.miijack.tournamentmanagement.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Participant {
    private long id;
    private String username;
    private String name;
    private LocalDate birthdate;
    private String team;
}
