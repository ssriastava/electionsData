drop table if exists electiondata;
drop table if exists city;
drop table if exists candidate;
drop table if exists election;
drop table if exists party;

CREATE TABLE city (
    cityid SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL
);



CREATE TABLE candidate (
    candidateid SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT,
    gender VARCHAR(10),
    address TEXT
    -- add more fields as needed
);


CREATE TABLE election (
    electionid SERIAL PRIMARY KEY,
    type VARCHAR(50) NOT NULL,     -- 'Lok Sabha', 'Vidhan Sabha', etc.
    year INT NOT NULL
);


CREATE TABLE party (
    partyid SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    abbreviation VARCHAR(20),
    symbol VARCHAR(100),
    founded_year INT
    -- add more if needed
);


CREATE TABLE electiondata (
    id SERIAL PRIMARY KEY,
    cityid INT NOT NULL,
    candidateid INT NOT NULL,
    electionid INT NOT NULL,
    partyid INT NOT NULL,
    votes INT NOT NULL,
    winlosestatus VARCHAR(10),  -- 'WIN' / 'LOSE' / 'TIE'

    -- Optional fields
    margin INT,
    rank INT,

    -- Foreign keys
    FOREIGN KEY (cityid) REFERENCES city(cityid),
    FOREIGN KEY (candidateid) REFERENCES candidate(candidateid),
    FOREIGN KEY (electionid) REFERENCES election(electionid),
    FOREIGN KEY (partyid) REFERENCES party(partyid)
);