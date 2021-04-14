# Lab assignment #2
A Java application (using the Maven build-automation tool) that reads a file with students’ grades, and generates its histogram.

## Prerequisites

Requirements for the software and other tools to build, test and push 
- [Java (jdk-11.0.10)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Eclipse IDE for Java Developers](https://www.eclipse.org/downloads/packages/)
- [Maven](https://maven.apache.org/download.cgi) (if running the project on command line)

## How to build and run the project

- Clone the repository to a local folder (```git clone https://github.com/marlenachatzigrigoriou/lab_assignments.git```)
- Open the command line in your cloned reporitory and enter ```mvn package```
- Enter the command ```java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar <path_to_your_local_grades_file>```
- The histogram has been generated !
