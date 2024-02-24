//Name:  		Anne Davis
//Student ID:	W204233986
//Assignment:	Project 1
//Class:		COSC 1436-22525
//Date:			February 7, 2021


import java.io.IOException;	//import Input/Output Exception
import java.io.File;		//import File class so we don't get an error on line 28
import java.util.Scanner;	//import Scanner class



public class aDavisProject1 {
	
	//start of defining method for reading and processing data from input file
	public static void processCOVIDData(String inputFile) throws IOException {
		
		//declare variables
	   String state = "";
	   long totalCase = 0;			// Total Cases
	   long totalDeath = 0;			// Total Deaths
	   long totalDeath100k = 0;		// Death_100k 
	   long population = 0;			// Population
	   long deathPercentage = 0;	// Death_100k %
	   
	
	   		
		// File object for the input file
	   File inFile = new File(inputFile);
		
		
		//Initialize Scanner Class fileReader to read the input file
		Scanner fileReader = new Scanner(inFile);
						
		// header and its formatting
		System.out.printf("%20s %15s %15s %15s %15s %15s\r\n","State", "Total Cases", "Total Deaths", "Death_100k", "Death_100k %", "Population");
		
		//bar under header, more formatting
		System.out.printf("---------------------------------------------------------------------------------------------------------------------------\r\n"); 
				
		// discards the header from the input file after reading it
		fileReader.nextLine();
		
		// fileReader will now read data set from txt file one datum at a time and assign it to specified variable
		while ( fileReader.hasNext() ) {
			state = fileReader.next() ;							//imports state names from txt file				
			totalCase  = fileReader.nextLong();		 			//imports total cases data set from txt file
			totalDeath  = fileReader.nextLong();				//imports total deaths per state data set from text file
			totalDeath100k  = fileReader.nextLong();			//imports total deaths per 100k data set from txt file
			

			// Processes collected data to give the death% and population 
			//Conditional statement included so that you don't get a divide by 0 error
			if (totalDeath==0)		
			{
				deathPercentage = 0;
			}
			else
			{deathPercentage = (totalDeath100k*100 / totalDeath ); //calculating deathPercentage
			
			}
			if(totalDeath100k==0)	
			{population = 0;
			
			}
			else
			{population = (totalDeath*100000 / totalDeath100k ); //calculating population
			
			}
			
		//Prints the data on the screen with proper spacing and %% to escape percent signs when needed
			System.out.printf("%20s %15s %15s %15s %15s%% %15s\r\n", state, totalCase, totalDeath, totalDeath100k, deathPercentage, population);
			
			
		}
		//finishes reading the file and closes fileReader
		fileReader.close();
	}	
	
	//main class, starting point for the program
	public static void main(String[] args) throws IOException {
		processCOVIDData("cdc_covid_data.txt");

	}

}

//  .    _  .       _____________
//  |\_|/__/|      /            \
///   / \/ \   \  / Isn't this   \
/// __|O||O|__  \ \  A+ code?    /
//|/_ \_/\_/ _\ |  \  __________/
//| | (____) | ||  |/
//\/\___/\__/  // _/
//(_/         ||
//|          ||\
//\        //_/ 
//\______//
//__|| __||
//(____(____)
//Thanks for your time professor!
