
import java.io.*;
import java.util.Scanner;

public class Tables {
	//fields
	int rows = 3;							//number of rows one for each set
	int size = 2;							//number of columns, first character, second corresponding number
	int words= 2;							//number of words in header
	String[] header=new String[words];		//array for header
	int[][] table = new int[rows][size];	//new array to hold table's number values	
	String fileName;						//name of File
	
	//constructor
	public Tables(String fileName)
	{
		this.fileName= fileName;
	}//end of constructor
	
	//methods
	/* .________________________________________.
	 * | Method: setTable                        \
	 * | reads from file, stores values in array ||
	 * | and returns that array                  ||
	 * |_________________________________________||
	 *  \________________________________________\|
	 */
	public void setTable() throws IOException
	{		
		int index = 0;							//set counter to zero for loop
		char ch=' ';							//hold character values to process
		String str = "";						//holder for Strings to be processed		
		
		//instantiate file to be read
		//Then references file in new instance of Scanner class to read it
		File file = new File(fileName);			
		Scanner inputFile = new Scanner(file);
		
		//to read first line and make array for header
		for (int i= 0; i<header.length; i++)
		{
			header[i]=inputFile.next();			
		}//end header's for loop
		
		//loop to read file and populate array with NUMBER values
		while (inputFile.hasNext() && index < table.length)
		{			
			table[index][0] = inputFile.nextInt();			//reads and stores the numerical part
			str= inputFile.next();							//grab the "Name' element from file
			ch=str.charAt(0);								//changes it from String to char
			table[index][1]=(int)(ch);						//save character to array as an int
			index++;
		}//end while loop
		inputFile.close();									//close file
	}//end of setTable method

	/*|``````````````````````````''||
	 *| Method: getHeader          ||
	 *| Returns a reference to the ||
	 *| header array               ||
	 * ============================\|
	 */
	public String[] getHeader()
	{
		return(header);
	}//end getHeader method

	/*|``````````````````````````''||
	 *| Method: getTable           ||
	 *| Returns a reference to the ||
	 *| table array                ||
	 * ============================\|
	 */
	public int[][] getTable()
	{
		return(table);
	}//end getTable method
	
	/*|``````````````````````````||
	 *| Method: getFileName      ||
	 *| Returns the name of file ||
	 *| as a string              ||
	 * ==========================\|
	 */
	public String getFileName()
	{
		return(fileName);
	}//end getFileName method
	
	/*|````````````````````````````````````````||
	 *| Method: printHeader                    ||
	 *| Prints the header for the table with a ||
	 *| bar to separate the table from header  ||
	 * ========================================\|
	 */
	public void printHeader()
	{
		for (int i=0; i<header.length;i++)
		{
			System.out.print(header[i] + "\t\t");		//PRINTS HEADER
		}//end for loop
		System.out.println("\n---------------------");	//adds a bar & advances to new line
	}//end printHeader method
	
	/*|``````````````````````````````````````````````````````||
	 *| Method: printTable                                   ||
	 *| Changes the int values back to original char form and||
	 *| prints values as a table to display where characters ||
	 *| are on the right column and numbers on the left.     ||
	 * ======================================================\|
	 */
	public void printTable()
	{
		for (int i=0; i<table.length; i++)				//loop cycles through array rows
		{
			char ch=(char)(table[i][1]);				//Turns int values back to the original char value 
			System.out.println(table[i][0] + "\t\t " + ch);	
		}//end of for loop				
	}//end of printTable method
	
	/* ______________________________
	 * | Method: Join              |\
	 * |Prints value from sets if  ||
	 * |there's a match on the key ||
	 * L___________________________\|
	 */
	public void join(int[][] table1, String[] header1, int[][] table2, String header2[])
	{
		//outer loop determines if they have lists of the same things.
		if ((header1[0].equals(header2[0])) && (header1[1].equals(header2[1])))
		{
			for (int i=0; i<table1.length; i++)				//loop to cycle through rows 
			{
				if (table1[i][0] == table2[i][0])			//comparing each item
				{
					char ch=(char)(table1[i][1]);			//Turns int values back to the original char value 
					System.out.println(table1[i][0] + "\t\t " + ch);					
				}//end inner if-statement
			}//end loop
		}//end outer if-statement		
	}//end Join method	
	
	/* ______________________________
	 * | Method: Union              |\
	 * |Prints all values from both ||
	 * |sets without duplicates.    ||
	 * L____________________________\|
	 */
	void union(int[][] table1, int[][] table2)
	{
														//loop prints all values from first table
		for (int i=0; i<table1.length;i++)
		{
			char ch=(char)(table1[i][1]);				 
			System.out.println(table1[i][0] + "\t\t " + ch);					
		}//end for loop printing table1	
		
														//loop to print only non-duplicate values from table2
		for (int i=0; i<table2.length; i++)				
		{
			if (table2[i][0] != table1[i][0])
			{
				char ch=(char)(table2[i][1]);			/ 
				System.out.println(table2[i][0] + "\t\t " + ch);					
			}//end if-statement
		}//end 2nd for loop
		System.out.println();							//gives a space between tables for ease of reading
	}//end of union method
	
	/* ______________________________
	 * | Method: intersection       |\
	 * |Prints out only values that ||
	 * |both sets do share.         ||
	 * L____________________________\|
	 */
	void intersection (int[][] table1, int[][] table2)
	{
		for (int i= 0; i<table1.length; i++)
		{
														//decision structure looks for matching ID & NAME
			if ((table1[i][0] == table2[i][0]) && (table1[i][1] == table2[i][1])) 
			{
				char ch=(char)(table1[i][1]);
				System.out.println(table1[i][0] + "\t\t " + ch);
			}//end of if-statement
		}//end for loop
		System.out.println(); 							//gives a space between tables
	}//end intersection method
	
	/* ______________________________
	 * | Method: Difference         |\
	 * |Prints out only values that ||
	 * |the sets don't share.       ||
	 * L____________________________\|
	 */
	void difference (int[][] table1, int[][] table2)
	{
		for (int i= 0; i<table1.length; i++)
		{
														//decision structure looks for IDs that don't match
			if (table1[i][0] != table2[i][0])
			{
				char ch=(char)(table1[i][1]);
				System.out.println(table1[i][0] + "\t\t " + ch);
			}//end of if-statement
		}//end for loop
		System.out.println();							//gives a space between tables
	}//end difference method
}//end tables class
