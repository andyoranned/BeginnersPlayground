/* Name: Anne Davis -- w204233986
 * Date: October 17, 2021
 * Class: COSC 1437- 13459
 * Assignment: Project II 
 * 				Create a program that:
 * 					1.Uses the provided data file for T1 and T2 as your input source.
 * 					2.Perform the relational algebra operations given above on these tables and display your result.
 * 					3.A friendly user interface
 * 					4.The source code must be documented and formatted using one of the generally accepted coding conventions
 */
import java.io.*;			//for file import 
import java.util.Scanner;	//for scanner class

public class RelationalAlgebra {

	public static void main(String[] args) throws IOException {
	
		//variables
		int arrayRow = 3;								//number of rows for array
		int arrayCol = 2;								//number of columns for array
		//arrays to hold tables returned from Tables getter method
		int[][] fileUnoArray= new int[arrayRow][arrayCol];
		int[][] fileDosArray= new int[arrayRow][arrayCol];
		//arrays to hold header returned from headerGetter method
		String[] headerUnoArray= new String[arrayCol];
		String[] headerDosArray= new String[arrayCol];
		
		//program starts here
		System.out.println("Welcome to the relational "	//prompt user to input source files for processing
				+ "algebra calculator!");
		System.out.println("Please enter the filename"
				+ " of your first table:");
		System.out.println("Actually, type \"T1.txt\"");
		
		Scanner kbd = new Scanner(System.in);			//Scanner class instance to use keyboard
		String fileNombre=kbd.nextLine();
				
		Tables fileUno=new Tables(fileNombre);			//make a new instance of Tables class w/ filename provided 
		//calling assorted methods for fileUno object		
		fileUno.setTable();								//call Table setter method. 
		System.out.println("\t"+ fileUno.getFileName());
		headerUnoArray = fileUno.getHeader();			//headerUnoArray now references header returned from fileUno
		fileUno.printHeader();							//prints header and table
		fileUno.printTable();							
		fileUnoArray= fileUno.getTable();				//fileUnoArray references table built in setTable()
		
		//prompting user
		System.out.println("Please enter the filename of"
				+ " your second table:");
		System.out.println("For this assignment type \"T2.txt\"");
		String fileNombre2=kbd.nextLine();				 
				
		Tables fileDos=new Tables(fileNombre2);			//second instance of Tables class
		//calling assorted methods on fileDos object
		fileDos.setTable();								//Table set with info from T2.txt
		System.out.println("\t"+ fileDos.getFileName());
		fileDos.printHeader();							//line 54-55 prints second table w/ header
		fileDos.printTable();
		System.out.println(); 							//gives a space between this table and next
		fileDosArray = fileDos.getTable();				//references table from T2.txt
		headerDosArray = fileDos.getHeader();			//headerDosArray references the header from T2.txt file
		
		//START OF RELATIONAL ALGEBRA OPERATIONS
		//UNION
		System.out.println("  " + fileUno.getFileName() + " \u22C3 " + fileDos.getFileName() );
		System.out.println("       UNION");
		fileUno.printHeader();
		fileUno.union(fileUnoArray, fileDosArray);
		
		//Intersection
		System.out.println("  " + fileUno.getFileName() + " \u22C2 " + fileDos.getFileName() );
		System.out.println("    Intersection");
		fileUno.printHeader();
		fileUno.intersection(fileUnoArray, fileDosArray);
		
		//DIFFERENCE-part1:  T1\T2
		System.out.println("   " + fileUno.getFileName() + " \\ " + fileDos.getFileName() );
		System.out.println("    Difference");
		fileUno.printHeader();
		fileUno.difference(fileUnoArray, fileDosArray);
		//DIFFERENCE-part2:  T2\T1
		System.out.println("   " + fileDos.getFileName() + " \\ " + fileUno.getFileName() );
		System.out.println("    Difference");
		fileDos.printHeader();
		fileDos.difference(fileDosArray, fileUnoArray);
				
		//JOIN
		System.out.println("  " + fileUno.getFileName() + " \u22C8 " + fileDos.getFileName() );
		System.out.println("\tJOIN");
		fileUno.printHeader();
		fileUno.join(fileUnoArray, headerUnoArray, fileDosArray, headerDosArray);
	}//end main method
}//end RelationalAlgebra class