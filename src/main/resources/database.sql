-- Creation of Tournament Table
CREATE TABLE "tournament" (
     id serial PRIMARY KEY,
     name varchar(255) NOT NULL,
     type varchar(255),
     date timestamp NOT NULL,
     location varchar(255),
     description text
);

-- Creation of Participant Table
CREATE TABLE "participant" (
    id serial PRIMARY KEY,
    username varchar(255) UNIQUE NOT NULL,
    name varchar(255) NOT NULL,
    birthdate date,
    team varchar(255)
);

-- Creation of Match Table
CREATE TABLE "match" (
     id serial PRIMARY KEY,
     tournament_id int REFERENCES tournament(id) NOT NULL,
     participant1_id int REFERENCES participant(id) NOT NULL,
     participant2_id int REFERENCES participant(id) NOT NULL,
     match_date timestamp DEFAULT current_timestamp,
     participant1_score int DEFAULT 0,
     participant2_score int DEFAULT 0,
     round int,
     CHECK (participant1_id != participant2_id),
     CONSTRAINT check_round_sum CHECK (round = participant1_score + participant2_score)
);
