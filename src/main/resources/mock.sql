-- Inserting mock data into Tournament Table
INSERT INTO "tournament" (name, type, date, location, description)
VALUES
    ('Tekken Tournament', '1v1', '2023-08-15 10:00:00', 'Arcade Arena', 'A fierce Tekken competition'),
    ('Street Fighter Showdown', '1v1', '2023-09-05 13:30:00', 'Gamer''s Haven', 'Battle it out in Street Fighter'),
    ('Virtua Fighters Clash', '1v1', '2023-09-20 16:15:00', 'Retro Arcade', 'Who is the ultimate Virtua Fighter?'),
    ('Mortal Kombat Mayhem', '1v1', '2023-10-10 11:00:00', 'Dark Arena', 'Finish Him!'),
    ('Smash Bros. Brawl', '1v1', '2023-11-25 15:00:00', 'Game Nexus', 'Fight with your favorite characters');

-- Inserting mock data into Participant Table
INSERT INTO "participant" (username, name, birthdate, team)
VALUES
    ('NinaKiller', 'Nina Williams', '1980-04-22', 'Team Mishima'),
    ('RyuMaster', 'Ryu Hoshi', '1985-07-21', NULL),
    ('LeiWulongFan', 'Lei Wulong', '1988-02-10', 'Kung Fu Alliance'),
    ('MaiShiranui', 'Mai Shiranui', '1993-11-15', 'Team Fatal Fury'),
    ('KingOfIron', 'Paul Phoenix', '1979-09-08', NULL),
    ('FightingFleur', 'Cammy White', '1990-05-03', 'Delta Red'),
    ('BlackWidow', 'Yelena Belova', '1992-08-17', NULL),
    ('ThunderGod', 'Raiden Hashimoto', '1987-06-12', 'Mortal Kombat Clan'),
    ('SamuraiSoul', 'Haohmaru Kusanagi', '1992-12-04', 'Shinsengumi'),
    ('SonicSlash', 'Hilde von Krone', '1991-01-25', 'Wolfram Kingdom'),
    ('CyberNinja', 'Cyber Sub-Zero', '1995-03-08', 'Lin Kuei'),
    ('Speedster', 'Sonic the Hedgehog', '1991-06-23', NULL),
    ('WarriorPrincess', 'Xena Amazonian', '1990-09-15', NULL),
    ('DinoRider', 'Lara Croft', '1992-02-14', NULL),
    ('ElegantMage', 'Gandalf Grey', '2000-10-01', 'Fellowship'),
    ('SpaceInvader', 'Zim Invader', '2001-12-25', 'Irken Empire'),
    ('PlumberBro', 'Mario Mario', '1981-07-09', 'Super Mushroom Kingdom'),
    ('PrincessSaver', 'Link Hero', '1986-02-21', 'Hyrule Knights');

-- Inserting mock data into Match Table
INSERT INTO "match" (tournament_id, participant1_id, participant2_id, participant1_score, participant2_score, round, match_date)
VALUES
    (1, 1, 3, 2, 1, 3, '2023-08-15 10:00:00'),
    (1, 2, 4, 0, 2, 2, '2023-08-15 11:00:00'),
    (1, 5, 6, 1, 2, 3, '2023-08-15 12:00:00'),
    (1, 7, 8, 2, 0, 2, '2023-08-15 13:00:00'),
    (1, 9, 10, 0, 2, 2, '2023-08-15 14:00:00'),
    (2, 11, 12, 2, 0, 2, '2023-08-15 15:00:00'),
    (2, 13, 14, 2, 0, 2, '2023-08-15 16:00:00'),
    (2, 15, 16, 1, 2, 3, '2023-08-15 17:00:00'),
    (2, 17, 1, 3, 2, 5, '2023-09-05 13:30:00'),
    (3, 9, 2, 1, 2, 3, '2023-09-05 14:30:00'),
    (3, 2, 5, 2, 1, 3, '2023-09-20 16:15:00'),
    (3, 3, 4, 2, 0, 2, '2023-09-20 17:15:00'),
    (4, 1, 6, 0, 2, 2, '2023-10-10 11:00:00'),
    (4, 3, 8, 1, 2, 3, '2023-10-10 12:00:00'),
    (4, 5, 10, 2, 0, 2, '2023-10-10 13:00:00'),
    (4, 7, 12, 2, 1, 3, '2023-10-10 14:00:00'),
    (5, 9, 14, 0, 2, 2, '2023-11-25 15:00:00'),
    (5, 11, 16, 2, 1, 3, '2023-11-25 16:00:00'),
    (5, 13, 8, 2, 0, 2, '2023-11-25 17:00:00'),
    (5, 15, 2, 0, 2, 2, '2023-11-25 18:00:00');

