package com.iress.toyrobot;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToyRobotTestDirection {

	@Test
	public void testDirection1() {
		ToyRobot toyRobotTest = new ToyRobot();
    	
    	String newDirection = toyRobotTest.changeDirection("LEFT", "NORTH");
    	assertEquals("WEST", newDirection);
    	
    	newDirection = toyRobotTest.changeDirection("LEFT", "SOUTH");
    	assertEquals("EAST", newDirection);
    	
    	newDirection = toyRobotTest.changeDirection("RIGHT", "EAST");
    	assertEquals("SOUTH", newDirection);
    	
    	newDirection = toyRobotTest.changeDirection("RIGHT", "WEST");
    	assertEquals("NORTH", newDirection);
	}
	
	@Test
	public void testDirection2() {
		ToyRobot toyRobotTest = new ToyRobot();
    	
		String newDirection = toyRobotTest.changeDirection("LEFTX", "NORTH");
    	assertEquals("NORTH", newDirection);
    	
    	newDirection = toyRobotTest.changeDirection("RIGHT", "SOUTH");
    	assertNotEquals("EAST", newDirection);
    	
    	newDirection = toyRobotTest.changeDirection("XRIGHT", "EAST");
    	assertEquals("EAST", newDirection);
    	
    	newDirection = toyRobotTest.changeDirection("LEFT", "WEST");
    	assertNotEquals("NORTH", newDirection);
	}

}
