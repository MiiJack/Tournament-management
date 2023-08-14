package com.miijack.tournamentmanagement.Model;

import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Tournaments {
    private int id;
    private String name;
    private String type;
    private Timestamp date;
    private String location;
    private String description;
}
