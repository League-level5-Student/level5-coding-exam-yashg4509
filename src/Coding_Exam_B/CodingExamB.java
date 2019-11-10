package Coding_Exam_B;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CodingExamB {
	static /*
	 * This is a logging program for collecting TODO comments in a program. The program will scan
	 * Through all the files in the Coding_Exam_B/classes package, and collect all the comments that start
	 * with //TODO: and write them to their own file. See the TODO_Log_example.txt file for an idea of what 
	 * the final file output will look like.
	 */
	String finale;
	static int occurences;
	static String fName;

	static ArrayList<String> lines = new ArrayList<>();
	
	
	public static String getLoggingInfo(String fileName) {
		 fName = "File: " + fileName;
		
		/*
		 * 1. Complete the getLoggingInfoMethod.
		 *    The method takes in a String for a file and returns a String. 
		 *    The method will open the file a read through it. It will then 
		 *    take all the comments that begin with //TODO: and combine them 
		 *    into one large String. The string will also state the file name and
		 *    the line number for where each TODO was found. '
		*/
		try {
			
			BufferedReader r = new BufferedReader(new FileReader(fileName));
			
			
			r.lines().forEach(line -> {

				if(line.contains("TODO")) {
					lines.add(line);
					occurences += 1;
				}
//				if(occurences <= 1) {
//					finale = fName + "\n" + line;
//					System.out.println(finale);
//				} else {
//					System.out.println(line);
//				}

			});
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = "";
		
		for (String l: lines) {
			result = fName + "\n" + l.trim();
		}
		System.out.println(result );
		return result + "\n";
	}
	
	public static void main(String[] args) {
		String finalLogString = getLoggingInfo("src/Coding_Exam_B/classes/Camera.java");
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracedImageViewer.java");
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracer.java");
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/Vector3.java");
		
		/*
		 * 2. Write the finalLogString to a file called TODO_Log.txt. The file should match TODO_Log_example.txt. 
		 */
		
		try {
			FileWriter fw = new  FileWriter("src/Coding_Exam_B/TODO_Log.txt", true);
			fw.write(finalLogString);
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
