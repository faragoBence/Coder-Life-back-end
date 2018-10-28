DROP TABLE IF EXISTS player_data_programming_languages;
DROP TABLE IF EXISTS computers;
DROP TABLE IF EXISTS houses_decorations;
DROP TABLE IF EXISTS houses;
DROP TABLE IF EXISTS decorations;
DROP TABLE IF EXISTS chairs;
DROP TABLE IF EXISTS refrigerators;
DROP TABLE IF EXISTS beds;
DROP TABLE IF EXISTS inventory_books;
DROP TABLE IF EXISTS inventory_consumables;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS consumables;
DROP TABLE IF EXISTS ides;
DROP TABLE IF EXISTS hdds;
DROP TABLE IF EXISTS psus;
DROP TABLE IF EXISTS rams;
DROP TABLE IF EXISTS cpus;
DROP TABLE IF EXISTS vgas;
DROP TABLE IF EXISTS player_data;
DROP TABLE IF EXISTS job_requirements;
DROP TABLE IF EXISTS jobs;
DROP TABLE IF EXISTS programming_languages;
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users CASCADE;


CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(60) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    email VARCHAR(254)
);

CREATE TABLE authorities (
    username VARCHAR(60) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users("username")  ON DELETE CASCADE,
    UNIQUE (username, authority)
);

CREATE TABLE programming_languages (
  id SERIAL PRIMARY KEY,
  name VARCHAR(32) NOT NULL
);

CREATE TABLE jobs (
  id SERIAL PRIMARY KEY,
  name VARCHAR(16) NOT NULL,
  salary INTEGER NOT NULL
);

CREATE TABLE job_requirements (
  id SERIAL PRIMARY KEY,
  job_id INTEGER NOT NULL,
  language_id INTEGER NOT NULL,
  min_level INTEGER NOT NULL,
  FOREIGN KEY (job_id) REFERENCES jobs(id),
  FOREIGN KEY (language_id) REFERENCES programming_languages(id)
);

CREATE TABLE player_data (
  id SERIAL PRIMARY KEY,
  user_id INTEGER NOT NULL,
  experience INTEGER NOT NULL,
  level INTEGER NOT NULL,
  hunger INTEGER NOT NULL,
  energy INTEGER NOT NULL,
  money INTEGER NOT NULL,
  ruby INTEGER NOT NULL,
  active_job_id INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE ,
  FOREIGN KEY (active_job_id) REFERENCES jobs(id)
);



CREATE TABLE vgas (
  id SERIAL PRIMARY KEY,
  name VARCHAR(128) NOT NULL,
  price INTEGER NOT NULL,
  req_power INTEGER NOT NULL,
  click_multiplier NUMERIC(2,2) NOT NULL
);

CREATE TABLE cpus (
  id SERIAL PRIMARY KEY,
  name VARCHAR(128) NOT NULL,
  price INTEGER NOT NULL,
  req_power INTEGER NOT NULL,
  offline_earnings_multiplier NUMERIC(2,2) NOT NULL
);

CREATE TABLE rams (
  id SERIAL PRIMARY KEY,
  name VARCHAR(128) NOT NULL,
  price INTEGER NOT NULL,
  req_power INTEGER NOT NULL,
  experience_multiplier NUMERIC(2,2) NOT NULL
);

CREATE TABLE psus (
  id SERIAL PRIMARY KEY,
  name VARCHAR(128) NOT NULL,
  price INTEGER NOT NULL,
  power_unit INTEGER NOT NULL
);

CREATE TABLE hdds (
  id SERIAL PRIMARY KEY,
  name VARCHAR(128) NOT NULL,
  price INTEGER NOT NULL,
  req_power INTEGER NOT NULL,
  capacity INTEGER NOT NULL
);

CREATE TABLE ides (
  id SERIAL PRIMARY KEY,
  language_id INTEGER NOT NULL,
  title VARCHAR(64) NOT NULL,
  req_space INTEGER NOT NULL,
  click_multiplier NUMERIC(2,2) NOT NULL,
  FOREIGN KEY (language_id) REFERENCES programming_languages(id)
);

CREATE TABLE consumables (
  id SERIAL PRIMARY KEY,
  name VARCHAR(16) NOT NULL,
  price INTEGER NOT NULL,
  hunger_refill INTEGER NOT NULL,
  energy_refill INTEGER NOT NULL
);

CREATE TABLE books (
  id SERIAL PRIMARY KEY,
  name VARCHAR(16) NOT NULL,
  price INTEGER NOT NULL,
  language_id INTEGER NOT NULL,
  experience_gain INTEGER NOT NULL,
  FOREIGN KEY (language_id) REFERENCES programming_languages(id)
);


CREATE TABLE inventory (
  id SERIAL PRIMARY KEY,
  user_id INTEGER NOT NULL,
  capacity INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE inventory_consumables (
  inventory_id INTEGER NOT NULL,
  books_id INTEGER NOT NULL,
  amount INTEGER NOT NULL
);

CREATE TABLE inventory_books (
  inventory_id INTEGER NOT NULL,
  books_id INTEGER NOT NULL,
  amount INTEGER NOT NULL
);


CREATE TABLE beds (
  id SERIAL PRIMARY KEY,
  name VARCHAR(16) NOT NULL,
  price INTEGER NOT NULL,
  energy_refill INTEGER NOT NULL
);

CREATE TABLE refrigerators (
  id SERIAL PRIMARY KEY,
  name VARCHAR(16) NOT NULL,
  price INTEGER NOT NULL,
  max_hunger_value INTEGER NOT NULL
);

CREATE TABLE chairs (
  id SERIAL PRIMARY KEY,
  name VARCHAR(16) NOT NULL,
  price INTEGER NOT NULL,
  max_energy_value INTEGER NOT NULL
);

CREATE TABLE tables (
  id SERIAL PRIMARY KEY,
  name VARCHAR(16) NOT NULL,
  price INTEGER NOT NULL,
  offline_earnings_duration INTEGER NOT NULL
);

CREATE TABLE decorations (
  id SERIAL PRIMARY KEY,
  name VARCHAR(16) NOT NULL,
  price INTEGER NOT NULL,
  click_multiplier NUMERIC(2,2) NOT NULL
);

CREATE TABLE houses (
  id SERIAL PRIMARY KEY,
  level INTEGER NOT NULL,
  user_id INTEGER NOT NULL,
  bed_id INTEGER,
  refrigerator_id INTEGER,
  chair_id INTEGER,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
  FOREIGN KEY (bed_id) REFERENCES beds(id),
  FOREIGN KEY (refrigerator_id) REFERENCES refrigerators(id),
  FOREIGN KEY (chair_id) REFERENCES chairs(id)
);

CREATE TABLE houses_decorations (
  house_id INTEGER NOT NULL,
  decoration_id INTEGER NOT NULL,
  FOREIGN KEY (house_id) REFERENCES houses(id),
  FOREIGN KEY (decoration_id) REFERENCES decorations(id)
);

CREATE TABLE computers (
  id SERIAL PRIMARY KEY,
  user_id INTEGER NOT NULL,
  vga_id INTEGER,
  cpu_id INTEGER,
  ram_id INTEGER,
  psu_id INTEGER,
  hdd_id INTEGER,
  free_space INTEGER,
  activated BOOLEAN,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
  FOREIGN KEY (vga_id) REFERENCES vgas(id),
  FOREIGN KEY (cpu_id) REFERENCES cpus(id),
  FOREIGN KEY (ram_id) REFERENCES rams(id),
  FOREIGN KEY (psu_id) REFERENCES psus(id),
  FOREIGN KEY (hdd_id) REFERENCES hdds(id)
);

CREATE TABLE player_data_programming_languages (
  player_id INTEGER NOT NULL,
  language_id INTEGER NOT NULL,
  experience INTEGER NOT NULL,
  level INTEGER NOT NULL,
  FOREIGN KEY (language_id) REFERENCES programming_languages(id),
  FOREIGN KEY (player_id) REFERENCES player_data(id)
);






