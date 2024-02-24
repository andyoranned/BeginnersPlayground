
import java.io.IOException;	//import Input/Output Exception
import java.io.File;		//import File class so we don't get an error on line 28
import java.util.Scanner;	//import Scanner class

public class Blank {
	

	//main class, starting point for the program
	public static void main(String[] args) throws IOException {
		double length=0;
		   int counter=0;
		   
		
		   		
			// File object for the input file
		   File inFile = new File("NZBIRDS.txt");
			
			//Initialize Scanner Class fileReader to read the input file
			Scanner fileReader = new Scanner(inFile);
			
			// fileReader will now read data set from txt file one datum at a time and assign it to specified variable
			while ( fileReader.hasNext() ) {
				for(int i=0; i<10; i++)
					fileReader.next();
				length+=fileReader.nextDouble();
				counter++;
					
			}//whileloop
			
			//finishes reading the file and closes fileReader
			fileReader.close();
			System.out.println("Average= "+ (length/counter));
			
		}	
		

	}
