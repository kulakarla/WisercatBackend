CREATE TABLE pets (
  id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  id_code UUID DEFAULT RANDOM_UUID(),
  name VARCHAR(100),
  animal VARCHAR(100),
  color VARCHAR(100),
  country VARCHAR(100),
  user_id INT
);

CREATE TABLE animals (
  id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name VARCHAR(100)
);

CREATE TABLE colors (
 id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
 name VARCHAR(100)
);

CREATE TABLE countries (
 id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
 name VARCHAR(100)
);

CREATE TABLE users (
 id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
 username VARCHAR(100),
 password VARCHAR(100)
);

INSERT INTO users(username, password) VALUES ('hei', 'sinaseal');
INSERT INTO countries(name) VALUES ('norway');
INSERT INTO colors(name) VALUES ('red');
INSERT INTO animals(name) VALUES ('dog');
INSERT INTO pets(name, animal, color, country, user_id) VALUES ('kuki', 'dog', 'red', 'eesti', 1);
INSERT INTO pets(name, animal, color, country, user_id) VALUES ('muki', 'cat', 'blue', 'soome', 1);