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

Application that cleans records, adds to a database, and then allows users to filter and select data using an API

## Set Up
*Software Requirements*
- JDK 17
- MySQL

*Setup database*
- Create database 'films' in MySQL
- Run schema.sql from src/main/resources/schema.sql
- Create mysql.properties file and put username and password.

## Description / how to use (how to use can be separated later)
**How to use**
- Download project from intellij.
- Run Maven compile to build the project.
- Run ImdbMoviesApiApplication.java class.

## Quality Assurance
*How to run Test*
Run the following on the terminal

    > mvn clean test

**Cucumber used for end to end tests**

*The image shows the cucumber test report which shows that film data from csv has been loaded successfully**

<img src="src/test/resources/testEvidence/End_To_End_Test.png" />

- Junit used for unit testing giving above 80% coverage
- Quality Gate used to check the overall code quality

## (Optional) Creation Process
*add how we tackled this project, the steps we took and what order, optional as it can be combined with diffictuties.

## (Optional) Difficulties / learning experiences
*add details of any issues*

## Links
*any useful links*

## Contributors

 Jack Mardell, Daniel Webb, Mustapha Chedid, Luke Homer, George Heath, Youmna Khan, Ahmad Abubakar,Adil Salamat
