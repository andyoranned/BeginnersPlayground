
public class Employee {
	private int yearHire;
	private int yearDepart;
	
	/***************.
	 *  Constructor |
	 *~~~~~~~~~~~~~/
	 */
	public Employee()
	{
		yearHire=(int) (Math.random()*21);						//randomly generate year hired
		yearDepart=(int)(Math.random()*(21-(yearHire))+(yearHire+1)); //randomly generate departure year with year hire minimum
	}//end constructor

	/***********
	 * Methods |
	 * ~~~~~~~~
	 */
	public int getYearHire()
	{
		return yearHire;										//get the year hired
	}//end getYearHire method
	
	public int getYearDepart()
	{
		return yearDepart;										//get the departure year
	}//end getYearDepart method
}//end employee class
