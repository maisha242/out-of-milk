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
    roommateog int REFERENCES users(id),
    roommateone int REFERENCES users(id),
    roommatetwo int REFERENCES users(id),
    roommatethree int REFERENCES users(id)
);

CREATE TABLE kitchen(
    kitchenid SERIAL PRIMARY KEY,
    itemone int REFERENCES items(itemid),
    itemtwo int REFERENCES items(itemid),
    itemthree int REFERENCES items(itemid)
);

CREATE TABLE items(
    itemid SERIAL PRIMARY KEY,
    name VARCHAR(255),
    quantity int NOT NULL,
    buydate date
);
