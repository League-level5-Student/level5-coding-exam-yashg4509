package Coding_Exam_A;

import java.awt.Color;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		
		String count = JOptionPane.showInputDialog("How many robots?");
		int countInteger = Integer.parseInt(count);
		
		String color = JOptionPane.showInputDialog("Do you want red, green or blue?");
		Color c = Color.getColor(color);
		
		String sides = JOptionPane.showInputDialog("How many sides do you want the shape to have?");
		int s = Integer.parseInt(sides);
		
		Robot[] robotsList = new Robot[countInteger];
		Stream<Robot> robotsStream = Arrays.stream(robotsList);
		
		robotsStream.forEach(r -> {
			r = new Robot();
			r.penDown();
			r.setSpeed(9);
			r.setPenColor(c);
			r.setX(new Random().nextInt(1500));
		
			
			
			for (int i = 0; i < s; i++) {
				r.move(50);
				r.turn(360/s);
			}

		});		
	}
}
