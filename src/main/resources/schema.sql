DROP TABLE IF EXISTS `films`;

CREATE TABLE IF NOT EXISTS films (
  title varchar(100) NOT NULL COMMENT 'title of film',
  score DECIMAL NOT NULL COMMENT 'film imdb score',
  release_year DATE NOT NULL COMMENT 'film release year',
  duration INT NOT NULL COMMENT 'duration of the film in minutes',
  rating VARCHAR(10) NOT NULL COMMENT 'the films age rating',
  budget BIGINT NOT NULL COMMENT 'the films budget',
  genres VARCHAR(250) NOT NULL COMMENT 'the films genre',
  gross BIGINT NOT NULL COMMENT 'gross income of the film',
  director VARCHAR(150) NOT NULL COMMENT 'the films director',
  actor1 VARCHAR(150) NOT NULL COMMENT 'a featured actor of the film',
  actor2 VARCHAR(150) NOT NULL COMMENT 'a featured actor of the film',
  actor3 VARCHAR(150) NOT NULL COMMENT 'a featured actor of the film',
  film_language VARCHAR(60) NOT NULL COMMENT 'the films language',
  country VARCHAR(70) NOT NULL COMMENT 'the films country of production'
);