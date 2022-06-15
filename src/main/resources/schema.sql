DROP TABLE IF EXISTS `films`;

CREATE TABLE IF NOT EXISTS films (
  film_id BIGINT PRIMARY KEY COMMENT 'film id',
  title varchar(100) NOT NULL COMMENT 'film title',
  score DECIMAL NOT NULL COMMENT 'films imdb score',
  release_year INT NOT NULL COMMENT 'films release year',
  duration INT NOT NULL COMMENT 'films duration in minutes',
  rating VARCHAR(10) NOT NULL COMMENT 'films age rating',
  budget BIGINT NOT NULL COMMENT 'films allocated budget',
  genres VARCHAR(250) NOT NULL COMMENT 'films genre',
  gross BIGINT NOT NULL COMMENT 'films gross income',
  director VARCHAR(150) NOT NULL COMMENT 'films director',
  actor1 VARCHAR(150) NOT NULL COMMENT 'featured actor of the film',
  actor2 VARCHAR(150) NOT NULL COMMENT 'featured actor of the film',
  actor3 VARCHAR(150) NOT NULL COMMENT 'featured actor of the film',
  film_language VARCHAR(60) NOT NULL COMMENT 'films spoken language',
  country VARCHAR(70) NOT NULL COMMENT 'the country that produced the film'
);