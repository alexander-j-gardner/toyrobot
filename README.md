# Toyrobot programming exercise

## Program Description

- The application is a simulation of a toy robot moving on a square tabletop, of dimensions 5 units x 5 units
- There are no other obstructions on the table surface
- The robot is free to roam around the surface of the table, but must be prevented from falling to destruction. Any movement that would result in the robot falling from the table must be prevented, however further valid movement commands must still be allowed

## How to the run the program

### Install Maven

Maven will be required to build and run the program. You can find instructions on how to download and install maven here: 

```
https://www.apache.org/
```


### Download the project using git

Download the project using git and then run the following git command:
```
git clone https://github.com/alexander-j-gardner/toyrobot.git
```


### Build the project

Build the project using Maven to create an executable JAR using the following command:

```
mvn clean compile assembly:single
```

Look for the executable JAR named **zone-toyrobot-1.0.jar** in the **target** directory of the project.


### Run the executable JAR

Before running the JAR you must create a file containing commands for the toy robot, an example of which can be found in **test/resources/ToyRobotCommands.txt**

Run the executable JAR, **zone-toyrobot-1.0.jar**, using the following command:

```
java -jar zone-toyrobot-1.0.jar [ path & name of your command file ] 

```

The output is written to System.out. Should you use the example commands file, **test/resources/ToyRobotCommands.txt**, the output will be the following:

```
Output:0,1,NORTH
Output:0,0,WEST
Output:3,3,NORTH
``` 

## Improvements

- Use a dependency injection framework such Spring or Guice, to build the objects in the projects;
- Allow multiples of a command e.g. MOVE 3 would move the robot in the same direction 3 times;

