package com.iress.toyrobot;

import static org.junit.Assert.*;

import org.junit.Test;

public class ToyRobotTestLocation {

	@Test
	public void testLocation1() {
		ToyRobot toyRobotTest = new ToyRobot();
    	
    	int newLocation = toyRobotTest.moveRobot(0, "NORTH");
    	assertEquals(1, newLocation);
    	
    	newLocation = toyRobotTest.moveRobot(1, "SOUTH");
    	assertEquals(0, newLocation);
    	
    	newLocation = toyRobotTest.moveRobot(2, "EAST");
    	assertEquals(3, newLocation);
    	
    	newLocation = toyRobotTest.moveRobot(3, "WEST");
    	assertEquals(2, newLocation);
	}
	
	@Test
	public void testLocation2() {
		ToyRobot toyRobotTest = new ToyRobot();
    	
    	int newLocation = toyRobotTest.moveRobot(6, "NORTH");
    	assertEquals(0, newLocation);
    	
    	newLocation = toyRobotTest.moveRobot(0, "SOUTH");
    	assertEquals(0, newLocation);
    	
    	newLocation = toyRobotTest.moveRobot(4, "EAST");
    	assertEquals(4, newLocation);
    	
    	newLocation = toyRobotTest.moveRobot(-6, "WEST");
    	assertEquals(0, newLocation);
	}

}
