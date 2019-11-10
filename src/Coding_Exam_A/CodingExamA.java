package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	static String numRobotsInput = JOptionPane.showInputDialog("How many robots do you want?");
	static int numRobots = Integer.parseInt(numRobotsInput);	
		
	static String colorInput = JOptionPane.showInputDialog("What color do you want: red, green, or blue?");
	static Color c = Color.getColor(colorInput.toUpperCase());
	
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. Using the robots, draw hexagopns
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		
		int xPos = 100;
		int yPos = 500;
		Robot[] robots = new Robot[numRobots];
		for (int i = 0; i < robots.length; i++) {
			robots[i] = new Robot(xPos, yPos);
			robots[i].setSpeed(10);
			robots[i].setPenColor(c);
			robots[i].penDown();
			xPos += 400;
		}
		
		for(Robot r: robots) {
//			r.setSpeed(10);
//			r.penDown();
//			r.setPenColor(c);
			new Thread(() -> drawPentagon(r)).start();
		}

	}
	
	public static void drawPentagon(Robot r) {
//			r.setSpeed(10);
//			r.penDown();
//			r.setPenColor(c);
		for (int i = 0; i < 6; i++) {
//			r.setSpeed(10);
//			r.penDown();
//			r.setPenColor(c);
			r.move(100);
			r.turn(360/6);
			
		}
	}
}
