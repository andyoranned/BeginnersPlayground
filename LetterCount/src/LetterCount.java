/* Name: Anne Davis -- w204233986
 * Date: September 13, 2021
 * Class: JAVA II
 * Assignment: Project I 
 * 				Create a program that:
 * 					Reads input file
 * 					Counts the number keystrokes
 * 					Generate a report & save to output file
 */

//import necessary packages/classes
import java.util.Scanner;
import java.io.*;

public class LetterCount {
	/*  ___________________
	 * |   Main Method     |
	 * |Program starts here|
	 * |___________________| 
	 */
	public static void main(String[] args) throws IOException {
		
		//variables 
		String fileName; 						//holds the input file name
		final int rows = 2;						//number of rows in freq array
		final int columns = 26;					//number of columns in freq array
		int[][] freq=new int[rows][columns];	//2d array to accumulate frequency
		
		//scanner object for keyboard input
		Scanner kbd= new Scanner(System.in);
		//prompt user for fileName
		System.out.println("This program determines the frequency of characters in a txt file.\nWhat file do you want analyzed?");
		System.out.println("For the purpose of this assignment type \"lisp.txt\" ");
		fileName= kbd.nextLine();
		Report r=new Report();					//create an instance of report class
		freq =r.getArray(fileName);				//reads file and stores character frequency in array
		
		
		r.generateReport(freq);					//creates and saves report
	} //end of main method
} //end LetterCount Class
