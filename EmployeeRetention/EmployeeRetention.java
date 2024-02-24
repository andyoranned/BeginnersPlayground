/* Name: Anne Davis
 * Date: September 14, 2022
 * Assignment 1:  Create a program to measure employee retention.
 *                Prompt user for # of employees and randomly generate their state/leave dates
 *                Options - Display years with most hires/departures
 *                          Increase # employees
 *                          Display top 2 years with most employees
 *                          Display year with largest increase in total employees
 *                          Display comprehensive report
 *                          Exit
 */
import java.util.*;  //for keyboard input


public class EmployeeRetention {

	public static void main(String[] args) {
		
		int employeeNumInput;									//holds # of employees input from user
		int additionalEmployeeInput;							//holds # of additional employees input from user
		EmployeeInfoArrays arr;									//object that encapsulates all arrays
		int yearSelection;										//holds year selected by user
		boolean boo = true;										//controls enter/exit of menu
		
		System.out.print("Total number of employees: "); 		//prompt user
		
		Scanner keyboard= new Scanner(System.in);				//Can use the keyboard now
		employeeNumInput= keyboard.nextInt();					//Get employee # from user
		
		arr= new EmployeeInfoArrays(employeeNumInput);			//Create object to hold all our data structures
		
		for (int i=0; i<employeeNumInput; i++)					//populate employee list 
		{
			arr.addEmployee(i);
		}
		arr.countYearlyTotals(); 								//Count departures, hires &total employees for each year
		
		//Menu starts here
		while (boo==true)										//Keep going until valid option selected
			{													//prompt user
				System.out.println("Please make a selection: \n");	
																//Selection of options....		
				System.out.println("1 - Total employees, annually");
				System.out.println("2 - Years with most new employees and departures");
				System.out.println("3 - Increase number of employees");
				System.out.println("4 - Top 2 years with most employees");
				System.out.println("5 - Year with largest new hire spike");
				System.out.println("6 - Comprehensive report");
				System.out.println("7 - Exit");
				System.out.println("Choose option by typing corresponding number.");

				switch(keyboard.nextInt())						//Number user types corresponds with these outcomes
				{			
				case 1:
					System.out.println("What year?");
					yearSelection= keyboard.nextInt();			//User selects year
					arr.printTotalEmployeesAnnual(yearSelection);//shows values for that year			
					break;										//Exit Switch statement
							
				case 2:
					arr.findLargestValues();					//Prints years with most hires/departures
					break;										//Exit Switch
					
				case 3:											//Add more employees
					System.out.println("Add how many employees to total?");
					additionalEmployeeInput=keyboard.nextInt();	//How many extra employees?
					arr.increaseEmployeeDatabase(additionalEmployeeInput); //Create bigger array
						
																//populate new employees
					for (int i=employeeNumInput; i<(employeeNumInput+additionalEmployeeInput); i++)	
					{
						arr.addEmployee(i);
					}
					arr.countYearlyTotals(); 					//Update counts for departures, hires &total employees 
					System.out.printf("Total employees in data set now: %d \n\n",(employeeNumInput+additionalEmployeeInput));
					break;										//exit switch
					
				case 4:											
					arr.findTwoLargest();						//Display years with most, and next to most, total employees			
					break;
					
				case 5:
					arr.yearOverYearCalculation(); 				//Calculate change in total employees & display spike
					break;
					
				case 6:
					arr.printReport();							//comprehensive report
					break;
					
				case 7:
					boo=false;
					System.out.println("Thank you for choosing AnneSoft Technologies, LLC for your company's programming needs.");
					break;
					
				default:
					System.out.println("Selection invalid");	//Prompt user, again
				}//end switch statement
			}//end while loop
			keyboard.close();
			
	
	

	}//end main method
	
}//end EmployeeRetention class
