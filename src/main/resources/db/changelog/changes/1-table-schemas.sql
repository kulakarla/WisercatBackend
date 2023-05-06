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
 name VARCHAR(100),
 ISO VARCHAR(2)
);

CREATE TABLE users (
 id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
 username VARCHAR(100),
 password VARCHAR(200)
);
