# Lab assignments
![Build Status](https://travis-ci.com/marlenachatzigrigoriou/lab_assignments.svg?token=RvPtZ33KeadnU7un5SF8&branch=main)

This is a Maven project, including my Lab Assignments.

## Prerequisites

Requirements for the software and other tools to build, test and push 
- [Java (jdk-11.0.10)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/packages/)
- [Maven](https://maven.apache.org/download.cgi) (if running the project on command line)

## Lab assignment #2
A Java application (using the Maven build-automation tool) that reads a file with students’ grades, and generates its histogram.

### How to build and run the project

- Clone the repository to a local folder (```git clone https://github.com/marlenachatzigrigoriou/lab_assignments.git```)
- Open the command line in your cloned reporitory and enter ```mvn package```
- Enter the command ```java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar <path_to_your_local_grades_file>```
- The histogram has been generated !

## Lab assignment #3
A Java project for practicing jUnit test and code coverage.

### How to build and run the project

- Clone the repository to a local folder (```git clone https://github.com/marlenachatzigrigoriou/lab_assignments.git```)
- Open the command line in your cloned reporitory and enter ```mvn package jacoco:report```
- Browse unittesting folder: ..\lab_assignments\unittesting\target\site\jacoco and click on index.html .
- Now you can see on your browser the jacoco code coverage report.