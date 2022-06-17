[![Java CI with Maven](https://github.com/dhansak79/imdb-movies-engineering112/actions/workflows/maven.yml/badge.svg)](https://github.com/dhansak79/imdb-movies-engineering112/actions/workflows/maven.yml)

[![CodeScene Code Health](https://codescene.io/projects/27060/status-badges/code-health)](https://codescene.io/projects/27060)
[![CodeScene System Mastery](https://codescene.io/projects/27060/status-badges/system-mastery)](https://codescene.io/projects/27060)

[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=imdb-movies-engineering112&metric=coverage)](https://sonarcloud.io/summary/new_code?id=imdb-movies-engineering112)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=imdb-movies-engineering112&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=imdb-movies-engineering112)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=imdb-movies-engineering112&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=imdb-movies-engineering112)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=imdb-movies-engineering112&metric=bugs)](https://sonarcloud.io/summary/new_code?id=imdb-movies-engineering112)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=imdb-movies-engineering112&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=imdb-movies-engineering112)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=imdb-movies-engineering112&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=imdb-movies-engineering112)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=imdb-movies-engineering112&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=imdb-movies-engineering112)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=imdb-movies-engineering112&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=imdb-movies-engineering112)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=imdb-movies-engineering112&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=imdb-movies-engineering112)

# Engineering 112 Final Project

Application that cleans records, adds to a database, and then allows users to filter and select data
using an API

## Set Up

*Software Requirements*

- JDK 17

## Description / how to use (how to use can be separated later)

**How to use**

- Clone/Download project from GitHub
- From the command line run this command to have default film data:
  > java -jar IMDB-Movies-API-0.0.1-SNAPSHOT.jar
- From the command line run this command to use your own csv of film data:
  > java -jar IMDB-Movies-API-0.0.1-SNAPSHOT.jar "insert your file path here"
- To access the database open up a browser and navigate to
  > "http://localhost:8080/h2"
  > Hit connect to log into H2

- You can hit the endpoint  `localhost:8080/getFilms` to call the API and return all films

## Data Sample

A sample of the data can be found at:
> [Sample Data](./src/main/resources/imdb_data.csv)

- Column 1  => Movie title as a String.
- Column 2  => IMDB Score as a double.
- Column 3  => Movie release year as an Integer.
- Column 4  => Movie duration as an Integer.
- Column 5  => Movie Age ratings as a String.
- Column 6  => Movie budget as a Long.
- Column 7  => Movie genre as a String separated by |, e.g Action|Adventure|Comedy.
- Column 8  => Movie gross as a Long.
- Column 9  => Director's name as a String.
- Column 10 => Actor one as a String.
- Column 11 => Actor two as a String.
- Column 12 => Actor three as a String.
- Column 13 => Movie Language
- Column 14 => Movie Country

## Quality Assurance

*How to run Test*
Run the following on the terminal

    > mvn clean test

**Cucumber used for end to end tests**

*The image shows the cucumber test report which shows that film data from csv has been loaded
successfully**

<img src="src/test/resources/testEvidence/End_To_End_Test.png" />

- Junit used for unit testing giving above 80% coverage
- Quality Gate used to check the overall code quality

## (Optional) Creation Process

*add how we tackled this project, the steps we took and what order, optional as it can be combined
with diffictuties.

## (Optional) Difficulties / learning experiences

*add details of any issues*

## Links

*any useful links*

## Contributors

Jack Mardell, Daniel Webb, Mustapha Chedid, Luke Homer, George Heath, Youmna Khan, Ahmad
Abubakar,Adil Salamat
