-- Creation of Tournaments Table
CREATE TABLE tournaments (
     id serial PRIMARY KEY,
     name varchar(255) NOT NULL,
     type varchar(255),
     date timestamp NOT NULL,
     location varchar(255),
     description text
);

-- Creation of Participants Table
CREATE TABLE participants (
    id serial PRIMARY KEY,
    username varchar(255) UNIQUE NOT NULL,
    name varchar(255) NOT NULL,
    age int,
    team varchar(255)
);

-- Creation of Matches Table
CREATE TABLE matches (
     id serial PRIMARY KEY,
     tournament_id int REFERENCES tournaments(id) NOT NULL,
     participant1_id int REFERENCES participants(id) NOT NULL,
     participant2_id int REFERENCES participants(id) NOT NULL,
     match_date timestamp DEFAULT current_timestamp,
     participant1_score int DEFAULT 0,
     participant2_score int DEFAULT 0,
     round int

);
