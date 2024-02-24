
public class EmployeeInfoArrays {
	private Employee[] allEmployees;		//list of every employee ever
	private int allEmployeesElems;					
	private int nElems;						
	private int[] annualTotalEmployees;		//list of total employees for each year
	private int[] annualHires;				//list of total hires for each year
	private int[] annualDepartures;			//list of total departures for each year
	private int[] yearOverYearChange;     	//list of the change in total employees from previous year
	final int years = 22;					//number of years tracking
	
	/***************.
	 *  Constructor |
	 *~~~~~~~~~~~~~/
	 */
	EmployeeInfoArrays(int nElems)
	{														
		this.nElems=nElems;
		allEmployees=new Employee[this.nElems];
		allEmployeesElems=0;					//initialize all fields
		annualTotalEmployees = new int[years];
		annualHires= new int[years];
		annualDepartures= new int[years];
		yearOverYearChange=new int[years];		
	}//end constructor
	
	/***********
	 * Methods |
	 * ~~~~~~~~
	 * _______________________________________________________
	 * Create employee object that goes in the large array of |
	 * ever employee ever hired.   							  |
	 */
	public void addEmployee(int i)
	{
		allEmployees[i]= new Employee();					//creates new employee object & adds to array
		allEmployeesElems++;								//increase element counter
	}//end addEmployee method

	/*________________________________________
	 * For each employee, a tally is added to |
	 * arrays that track totals for hires,    |
	 * departures, and total employees for    |
	 * each year. The index corresponds to    |
	 * the year.                              |
	 */	
	public void countYearlyTotals()
	{
		for (int i=0; i<allEmployeesElems; i++)
		{
			for(int j=allEmployees[i].getYearHire(); j<=allEmployees[i].getYearDepart();j++)
			{
				if (j==allEmployees[i].getYearHire())		//Is this the year hired?
					annualHires[j]++;						//Yes, then add to running total of hires
				
				if (j==allEmployees[i].getYearDepart())		//This year of departure...?
				{
					annualDepartures[j]++;					//Yes, Add to depart tally
					annualTotalEmployees[j]--;				//And subtract from total employees tally
				}
				else
				{
					annualTotalEmployees[j]++;				//No, add to total employees tally
				}
			}//end inner for loop
		}//end outer for loop		
	}//end countYearlyTotals method
	
	/*____________________________________________________
	 * Prints the number of employees for the year passed |
	 * as the argument.
	 */
	void printTotalEmployeesAnnual(int annum)
	{
		System.out.printf("In the year %d, the company had %d total employees.\n\n", annum, annualTotalEmployees[(annum-2000)]);
	}//end printTotalEmployeesAnnual method

	/*____________________________________________________________
	 * Find the years that had the most new hires and departures. |
	 * Then print these values in formated string.                |
	 */
	void findLargestValues()
	{
		int searchHires=0;						//variables to hold values while searching for largest value
		int searchHiresYear=0;
		int searchDepart=0;
		int searchDepartYear=0;
		
		for (int i=0; i<21; i++ )				//find the year with most new hires
		{
			if(annualHires[i]>searchHires)
			{
				searchHires=annualHires[i];
				searchHiresYear= i;
			}//end if statement
		}//end loop
		
		for (int i=0; i<21; i++ )				//find the year with most departures
		{
			if(annualDepartures[i]>searchDepart)
			{
				searchDepart=annualDepartures[i];
				searchDepartYear= i;
			}//end if statement
		}//end loop
		
		System.out.printf("\nYear with most new hires: %d, with %d employees.\n",(searchHiresYear+2000), searchHires);
		System.out.printf("Year with most departures: %d, with %d employees.\n\n",(searchDepartYear+2000), searchDepart);
	}//end findLargestValues method
	
	/*______________________________________________________________
	 * Create new larger array. Transfer all objects from smaller	|
	 * array over then add new objects to fill the rest of the new	|
	 * array. When finished, get old reference variable to point	|
	 * to new array													|
	 */	
	void increaseEmployeeDatabase(int extraEmployees)
	{
		nElems+=extraEmployees;								//Get total employees after adding
		Employee[] increasedArray= new Employee[nElems];
		for (int i=0; i <allEmployeesElems;i++)
		{
			increasedArray[i]=allEmployees[i];				//copy contents of smaller array to bigger array	
		}//end for loop
		
		allEmployees=increasedArray; 						//allEmployees now points to the bigger array		
	}//end addEmployees method

	/*__________________________________________________________
	 * Find the two years with the largest and next to largest	|
	 * number of total employees.								|
	 */
	void findTwoLargest()
	{
		int value=0;									//place holders
		int valueYear=0;
		int secondValue=0;
		int secondValueYear=0;
		
		for (int i=0; i<21; i++ )						//look for greatest number
		{
			if(annualTotalEmployees[i]>value)			//when higher value is found
			{
				secondValueYear=valueYear;				//move previous high's year & value into 
				secondValue=value;						//second highest place holder
				value=annualTotalEmployees[i];			//update highest values
				valueYear=i;
			}//end if statement
		}//end loop
														//Print the results
		System.out.printf("The top two years with most employees were %d and %d with %d and %d employees, respectively.\n \n",(valueYear+2000), (secondValueYear+2000), value, secondValue);
	}//end findTwoLargest
	
	/*______________________________________________________
	 *  Determines change in new hires from previous year. |
	 *  Saves value to array. Index corresponds to year.   |
	 */
	public void yearOverYearCalculation()
	{
		for (int i=(years-2); i>0;i--)						//Start at 2020, working backwards
		{													//Find the difference in employees from the year before
			yearOverYearChange[i]=annualHires[i]-annualHires[i-1]; 
		}//end for loop
		yearOverYearChange[0]= annualHires[0];
		int marker=0;
		int yearMarker=0;
		for (int i=0; i<(years-1); i++ )					//find the highest change
		{
			if(yearOverYearChange[i]>marker)				//is it bigger than the last?
			{
				marker=yearOverYearChange[i];				//yes, record value
				yearMarker= i;								//record the year it happened
			}//end if statement
		}//end loop
		System.out.printf("The year with the highest spike in new hires, year over year, was %d. \n\n",(yearMarker+2000));
	}//end yearOverYearMath method

	/*__________________________________________________
	 * Print a formated report that displays the year	|
	 * count, new hires and departures.					|
	 */
	void printReport()
	{														//print formated header
		System.out.printf("%-15s %-15s %15s %15s \n", "Year", "Count", "New", "Departing");
		System.out.println("--------------------------------------------------------------------");
															//Formatting, a bar
		
		for (int i=0; i<21; i++)							//Each iteration prints values for 1 year
		{
			System.out.printf("%-15d %-15d %15d %15d \n", (i+2000), annualTotalEmployees[i], annualHires[i], annualDepartures[i]);
		}//end for loop
		System.out.println("-------------------------------------------------------------------");							
															//another bar		
	}//end printReport method
}//end of EmployeeInfoArrays class
