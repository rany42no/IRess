IRess Test - ToyRobot Application
Developer : Domiciano E. Fortuno (thru ProSource)
Date : August 30, 2022

Build Application :
- Extract the source code ToyRobot.zip
- Import the ToyRobot package to Eclipse
- Run Maven - clean install
- Executable jar file will be created in the targe folder

Run Application :
- Copy jar file or go to the jar file location
- Execute command : 'java -jar iress-toyrobot.jar'
- Input the commands on the console :
	PLACE X,Y,F 
	MOVE
	LEFT
	RIGHT
	REPORT
- Input 'X' to exit the program
	
Commands Reference :
PLACE X,Y,F - will put the toy robot on the table in position X,Y and facing (F) NORTH, SOUTH, EAST or WEST. Valid x/y values are 0,1,2,3 and 4.
MOVE - will move the toy robot one unit forward in the direction it is currently facing.
LEFT - will rotate the robot 90 degrees to the left without changing the position of the robot
RIGHT - will rotate the robot 90 degrees to the right without changing the position of the robot
REPORT - will print the current location and direction of the robot in the format : 'Output: X, Y, F'