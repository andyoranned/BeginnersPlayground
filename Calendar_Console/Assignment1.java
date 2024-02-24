/*  Name: Anne Davis
 *  Class: COSC 4331
 *  Date: Feb 1, 2023
 *  Assignment: Homework 1 -
 *              Create a calendar program that produces a monthly calendar of any month since Jan 1, 1800
 *              Must follow Gregorian Calendar conventions
 */

import java.util.Scanner;
 
public class Assignment1 {

	public static void main(String[] args) {
		
		while(true)										
		{
			System.out.print("Enter any year after 1800: ");			//prompt user to enter year
			Scanner kbd = new Scanner(System.in);						//keyboard can accept input
			int year=kbd.nextInt();
			System.out.println();
			if (year<1800)												//is year in the range?
			{
				System.out.println("You entered an invalid date.\n");	//no, inform user
				continue;												//start over
			}
			
			System.out.print("Enter a month, 1-12: ");					//prompt user for month
			int month=kbd.nextInt();
			System.out.println();
			if(month>12)												//valid month?
			{
				System.out.println("You entered an invalid date.\n");	//no, inform user
				continue;												//start over
			}
			
			Calendar requestedCalendar= new Calendar();
			requestedCalendar.printCalendar(month, year); 				//print requested calendar
		}//end while loop
	}//end main
}//end Assignment1 class____________________________________________________________________________________________

//Calendar class to contain calendar related methods
class Calendar {
	private int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //Array of  total days in each month. Index corresponds to the month

	//=========================================================Methods====\
	
	// Determine if the year is a leap year
	public boolean isLeapYear (int year)
	{
		if ((year%400==0) || ((year%4==0) && (year % 100!=0)))  //is it leap year?
			return true;										//yes
		return false;											//no		
	}//end isLeapYear______________________________________________________________________________________________

	//Determines which weekday the provided date occurs in the form 0-6 where 0 is Sunday 
	public int getDayOfWeek(int month, int day, int year)
	{
		int weekday=(getTotalNumOfDays(month, day, year) + 3) %7;//# days since Jan 1,1800, plus 3 to line up to a Sunday. Modulus 7 with give us the dates weekday
		return weekday;
	}//end getDayOfWeek____________________________________________________________________________________________

	//Determine how many days between Jan 1, 1800 and target date, NONINCLUSIVE.
	public int getTotalNumOfDays(int month, int day, int year)
	{
		int totalDays = ((year-1800) *365) + getNumOfLeapYears(year);//calculate the days from every year between 1800 and target year
		
		if ((month<3) && isLeapYear(year))						//haven't had the extra day for target (leap) year yet?
			totalDays--;										//no, remove 1 day from total
		
		//add the days in all the months of target year before target month
		for (int i=1; i<month; i++)
		{
			totalDays+=monthDays[i];							//add days of each month, i. Don't adjust Feb for leap years here, because 1 day has already been added for each leap year when initialized	
		}//end loop
		
		totalDays+=(day-1);										//add days from target month to total, minus 1 to not include target day
		return totalDays;			
	}//end getTotalNumOfDays_________________________________________________________________________________________

	//calculate how many leap years have occurred since 1800 to target year
	public int getNumOfLeapYears(int year)
	{
		int totalLeapYear=(((year/4)-(year/100))+(year/400))-436; //Calculate how many leap years from year 0 to target year and subtract the number of leap years since 1800.
		return totalLeapYear;
	}//end getNumOfLeapYears__________________________________________________________________________________________

	//Prints a formatted calendar of the month from the year that user specified
	public void printCalendar(int month, int year)
	{
		String[] weekdays= {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		String[] monthString= {" ", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		System.out.println();									
		System.out.printf("%19s, %-15d\n", monthString[month], year);//print formatted month/year
		System.out.println("--------------------------------------"); 
		
		for (int i=0; i <7; i++)								//print the days of the week
		{
			System.out.printf("%5s", weekdays[i]);
		}
		System.out.println(); 									//advance to new line
		
		int counter=getDayOfWeek(month,1,year);					//initialize counter with day of week that month starts on. Hardcoded because the start of a month can only occur on 1 and will never need changing
		
		for (int i=0; i<counter;i++)							//print a blank space for every day before the first to get the month to start on correct weekday
		{
			System.out.printf("%5s",monthString[0]);			
		}
		
		for (int i=1; i<=getNumOfDaysInMonth(month,year); i++)	//print numbers for each date
		{
			if (counter%7==0)									//made it to the end of the week?
				System.out.println();							//yes, advance to next line
			System.out.printf("%5d", i);
			counter++;											//tracks weekday
		}
		
		System.out.println("\nPress [ENTER] to continue. . . ");
		Scanner kbd= new Scanner(System.in);
		kbd.nextLine();											//wait until user advances
	}//end printCalendar___________________________________________________________________________________________
	
	//calculate how many days total are in the target month
	public int getNumOfDaysInMonth(int month, int year)
	{
		int daysInMonth = monthDays[month];								
		if ((month==2) && (isLeapYear(year)))					//is it Feb and a leap year?
		{
			daysInMonth++;										//yes, add an extra day	
		}
		return daysInMonth;
	}//end getNumOfDaysInMonth_______________________________________________________________________________________
}//end Calendar class


