# NextBike Api Tests

## Introduction
This repository contains API tests for the Nextbike networks

# Getting Started
POM is used to create the framework under 4 separate folders: runners, step_definitions, utilities and features.
1.	runner includes CukesRunner class which triggers the tagged test scenarios.
2.	step_definitions include the hard coding for the scenarios defined in feature files.
3.	utilities includes ConfigurationReader class which reads the data written in Configuration.properties file. 
    Configuration properties file contains the endpoint (url) to be used in API testing 

## Build and Test
This is a Cucumber BDD Test Framework in Java. 

## API Tests
Sample API test scenarios are written under 'Frankfurt.feature' file. 
These scenarios is verifying the retrieved data is equal to expected data provided as JSON format at the end point.

The scenario "As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude"
is written under 'Networks.feature' file. This scenario verifies Frankfurt is in Germany and returns its latitude and longitude values. 

### Requirements
You must have the following installed on your machine:
- [IntelliJ](https://www.jetbrains.com/idea/)
- [Java 8 or later](https://www.java.com/en/download/)

### Steps
1. Navigate to the same directory as this README
`cd <path-to-readme-directory>`.

2. To run from the command line, use this mvn command

`mvn clean verify -Dtest=CukesRunner`.

3. To run the tests using IntelliJ, use CukesRunner.class
4. To see the test report go to => target>cucumber-html-reports
