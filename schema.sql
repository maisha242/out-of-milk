DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roomies;
DROP TABLE IF EXISTS kitchen;
DROP TABLE IF EXISTS items;

CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    creation date,
    email VARCHAR(255)
);

CREATE TABLE roomies
(
    roomID SERIAL PRIMARY KEY,
    roommates int REFERENCES users(id)
);

CREATE TABLE kitchen(
    id SERIAL PRIMARY KEY,
    itemone int REFERENCES items(id),
    itemtwo int REFERENCES items(id),
    itemthree int REFERENCES items(id)
);

CREATE TABLE items(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    quantity int NOT NULL,
    buydate date
);
