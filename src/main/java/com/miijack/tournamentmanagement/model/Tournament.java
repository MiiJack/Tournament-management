package com.miijack.tournamentmanagement.model;

import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Tournament {
    private long id;
    private String name;
    private String type;
    private Timestamp date;
    private String location;
    private String description;
}
