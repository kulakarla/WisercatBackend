CREATE TABLE pets (
  id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  id_code UUID DEFAULT RANDOM_UUID(),
  name VARCHAR(100),
  animal_id INT,
  color_id INT,
  country_id INT,
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
INSERT INTO pets(name, animal_id, color_id, country_id, user_id) VALUES ('kuki', 1, 1, 1, 1);
INSERT INTO pets(name, animal_id, color_id, country_id, user_id) VALUES ('muki', 1, 1, 1, 1);