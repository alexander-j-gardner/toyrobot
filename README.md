# Toyrobot programming exercise

## Program Description

The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units
There are no other obstructions on the table surface
The robot is free to roam around the surface of the table, but must be prevented from falling to destruction. Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed

## How to the run the program

This project is built using Maven so you'll need to install Maven to build and run the program. 

```
- Download and install Maven, see (https://www.apache.org/)
- Download the project using the following git command:
  git clone https://github.com/alexander-j-gardner/toyrobot.git
- Build the project using Maven to create an executable JAR using the following command:
  mvn clean compile assembly:single
```

