package com.iress.toyrobot;

import java.util.Scanner;

/**
 *  
 *
 */

public class RobotApp 
{
    public static void main( String[] args )
    {		
    	try (Scanner in = new Scanner(System.in)) {	// Can be replaced by file input	
			ToyRobot toyRobot = new ToyRobot();
			String commandStr="";
			        
			System.out.println( "---- START" );
			
			do {
				commandStr = in.nextLine();				
				toyRobot.executeCommand(commandStr);				
			} while( !commandStr.equalsIgnoreCase("x") );
		}

        System.out.println("--- END ");
    }        
}
