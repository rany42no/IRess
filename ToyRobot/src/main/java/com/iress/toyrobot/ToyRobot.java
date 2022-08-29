package com.iress.toyrobot;

public class ToyRobot {
    
	private static final String NORTH="NORTH";
	private static final String EAST="EAST";
	private static final String SOUTH="SOUTH";
	private static final String WEST="WEST";
	private static final String LEFT="LEFT";
	private static final String RIGHT="RIGHT";
	private static final String MOVE="MOVE";
	private static final String PLACE="PLACE";
	private static final String REPORT="REPORT";
	
	private static final int MIN_LOCATION=0;
	private static final int MAX_LOCATION=4;
	
    private static int xLocation=0;
    private static int yLocation=0;
    private static String direction=EAST;
    private static boolean initLocPlaced=false;

	public void executeCommand(String commandStr) {	
	    
		if(commandStr.startsWith(PLACE)) {
    		// parse command string
			String placeCmdSplit[] = commandStr.split("PLACE");	
			String locDir;
			String locDirSplit[];
			int newXLoc;
			int newYLoc;			
			
			try {
				if (placeCmdSplit.length > 1) {
					locDir = placeCmdSplit[1].trim();
					locDirSplit = locDir.split(",");
					
					if (locDirSplit.length == 3) {
						newXLoc = Integer.parseInt(locDirSplit[0].trim());
						if((newXLoc >= MIN_LOCATION) && (newXLoc <= MAX_LOCATION))
							xLocation = newXLoc;
						
						newYLoc = Integer.parseInt(locDirSplit[1].trim());
						if((newYLoc >= MIN_LOCATION) && (newYLoc <= MAX_LOCATION))
							yLocation = newYLoc;						
						
						direction = locDirSplit[2].trim();
						
						// TODO validate PLACE params
						initLocPlaced = true;
					} else {
						System.out.println("Invalid command");
					}
				}
			} catch(NumberFormatException ne) {
				System.out.println("Invalid location input " + ne.getMessage());
			} catch(ArrayIndexOutOfBoundsException ae) {
				System.out.println("Invalid command parameters " + ae.getMessage());			
			}
    	}
		
		if(initLocPlaced) { // Only process other commands if initial PLACE command has been executed
			if(commandStr.equals(LEFT)) {
	    		direction=changeDirection(LEFT, direction);
	    	}
			else if(commandStr.equals(RIGHT)) {
	    		direction=changeDirection(RIGHT, direction);
			}
			else if(commandStr.equals(MOVE)) {
				if(direction.equals(EAST) || direction.equals(WEST)) {
					xLocation=moveRobot(xLocation, direction);
				} else if(direction.equals(NORTH) || direction.equals(SOUTH)) {
					yLocation=moveRobot(yLocation, direction);
				}
			}
			else if(commandStr.equals(REPORT)) {
				System.out.printf("Output: %d, %d, %s %n", xLocation, yLocation, direction);
			}
		}
		
		return;    	
	}	// executeCommand
	
	public String changeDirection(String shift, String currentDirection) {
    	String newDirection=currentDirection;
    	
    	if(shift.equals(LEFT)) {
    		switch(currentDirection) {
    	      case NORTH:
    	    	newDirection=WEST;
    	        break;
    	      case EAST:
      	    	newDirection=NORTH;
    	        break;
    	      case SOUTH:
      	    	newDirection=EAST;
    	        break;
    	      case WEST:
      	    	newDirection=SOUTH;
      	        break;
    	    }
    	} else if(shift.equals(RIGHT)) {
    		switch(currentDirection) {
	  	      case NORTH:
	  	    	newDirection=EAST;
	  	        break;
	  	      case EAST:
	    	    	newDirection=SOUTH;
	  	        break;
	  	      case SOUTH:
	    	    	newDirection=WEST;
	  	        break;
	  	      case WEST:
	    	    	newDirection=NORTH;
	    	        break;
	  	    }
    	}    
    	return newDirection;
    }	// changeDirection
    
	public int moveRobot(int moveLocation, String moveDirection) {
		if((moveLocation < MIN_LOCATION) || (moveLocation > MAX_LOCATION))
			return 0;
		
    	int newLocation=moveLocation;
    	
    	if(moveDirection.equals(NORTH) || moveDirection.equals(EAST)) {
	    	newLocation++;
    	} else if(moveDirection.equals(SOUTH) || moveDirection.equals(WEST)) {
	    	newLocation--;    		
    	}
    
    	// Prevent robot from falling off the table
    	if((newLocation < MIN_LOCATION) || (newLocation > MAX_LOCATION))
    		return moveLocation;
    	else
    		return newLocation;
    }	// moveRobot
    
}
