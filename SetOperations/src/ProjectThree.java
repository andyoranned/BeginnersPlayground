/* Name:			Anne Davis
 * Class:			COSC 1436 - 22525 (JAVA)
 * Assignment:		Project 3
 * Date:			May 2nd, 2021
 * 
 *   -------------------DO NOT EVER NEST 3 LOOPS LIKE I DID HERE!!!! Time complexity of ON^3 makes me cry just looking at it!!!! 
 */

//import necessary classes
import java.util.Scanner;

public class ProjectThree {
	/*___________________,
	 * Starting point for|
	 * program:          |
	 * main method       |
	 * ~~~~~~~~~~~~~~~~~~'
	 */
	public static void main(String[] args) {		
				
		//prompt user for length of first array
		System.out.println("Welcome! \nHow many numbers are in Set A?");
		
		Scanner kbd = new Scanner(System.in);		//create Scanner object for keyboard
		int length1=kbd.nextInt();				    //length of array designated by user
		kbd.nextLine();  							//consume remaining newLine character
		
		int[] firstGroup = new int[length1];		//create array to hold first group of values
		
		for (int i = 0; i<length1; i++)				//loop to populate firstGroup array
		{
			System.out.println("Input Set A:\nPress [ENTER] after each number.");
			firstGroup[i]=kbd.nextInt();
		}//end of for loop
		
		for(int i=0;i<(length1-1);i++)				//loop to remove duplicate numbers
			{
			for(int j=i+1;j<length1;j++)
				{
				if(firstGroup[i]==firstGroup[j])
					{
					for(int k=j;k<(length1-1);k++)
						{
						firstGroup[k]=firstGroup[k+1];
						}//end of innermost for loop
						
					length1-=1;
					}//end of if statement	       
				}//end of middle for loop
			}//end of outermost for loop
		
		System.out.println("How many numbers are in Set B?");
		
		int length2=kbd.nextInt();	   					//length of second array
		int[] secondGroup = new int[length2];			//create array to hold second group of values
		
		for (int i = 0; i<length2; i++)					//loop to populate secondGroup array
		{
			System.out.println("Input Set B:\nPress [ENTER] after each number.");
			secondGroup[i]=kbd.nextInt();				//holds value input by user
		}//end of for loop
		
		for(int i=0;i<(length2-1);i++)					//loop to remove duplicates
			{
			for(int j=i+1;j<length2;j++)
				{
				if(secondGroup[i]==secondGroup[j])
					{
					for(int k=j;k<(length2-1);k++)
						{
						secondGroup[k]=secondGroup[k+1];
						}//end of innermost for loop						
					length2-=1;
					}//end of if statement	       
				}//end of middle for loop
			}//end of outermost for loop
		
		//print union values
		System.out.print("A \u222a B = { ");						//print answer formatting
		union(firstGroup, length1, secondGroup, length2); 			//union method call
		System.out.print("}");										//print more formatting
		
		//print intersection values
		System.out.print("\nA \u2229 B = { ");				       //print intersection answer formatting
		intersection(firstGroup, length1, secondGroup, length2);   //method call to print intersecting values
		System.out.print("}");									   //Print more answer formatting
		
		//print complement values
		System.out.print("\nA'    = { ");							//A' answer formatting
		complement(firstGroup, length1, secondGroup, length2);		//complement method call to print values
		System.out.print("}");										//answer formatting
		
		System.out.print("\nB'    = { ");							//B' answer formatting
		complement(secondGroup, length2, firstGroup, length1);		//complement method call to print values
		System.out.print("}");										//answer formatting

	} //end of Main method
	/*_____________________________,
	 * method to evaluate sets     |
	 * complement                  |
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~'
	 */	
	public static void complement (int[] aGroup, int aLength, int[] bGroup, int bLength)
	{
		boolean duplicate = true;					//variable to hold value for duplicate marker

		for(int i = 0; i < aLength; i++)	
													//loop to identify & ignore duplicates
			{
			for(int j = 0; j < bLength; j++)
				{
				if(aGroup[i] != bGroup[j])
					{
					duplicate = false;
					}
				else
					{
					duplicate = true;
					break;
					}
				}//end of inner for loop
			
			if(duplicate == false)
				{
				System.out.print(aGroup[i]+" ");
				}//end of if statement
			}//end of outer for loop
	}//end complement method
	/*_____________________________,
	 * method to evaluate if sets  |
	 * intersect                   |
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~'
	 */
	public static void intersection (int[] aGroup, int aLength, int[] bGroup, int bLength)
	{
		for (int i = 0; i < aLength; i++ ) 					//loop to cycle through Set A's elements
			{
            for (int j = 0; j < bLength; j++)				//loop to cycle through Set B's elements
            	{											//_______________________________________,
            	if (aGroup[i] == bGroup[j])					//*If statement to compare A&B's elements|
                	{										//*If elements intersect, it is printed  |
                    System.out.print(bGroup[j] + " ");		//*If not, loop advances                 |
                    }										//---------------------------------------'
                }//end if statement
            }//end inner for loop
	}//end intersection method
	/*_____________________________,
	 * method to perform union of  |
	 * sets' values                |
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~'
	 */
	public static void union (int[] aGroup, int aLength, int[] bGroup, int bLength)
	{
		boolean duplicate = true;						//variable to hold t/f value for duplicate marker
		
		printValues(aGroup, aLength);					//method call to print firstGroup values
		
		for(int i = 0; i < bLength; i++)	
														//loop to identify & ignore duplicates
			{
			for(int j = 0; j < aLength; j++)
				{
				if(bGroup[i] != aGroup[j])
					{
					duplicate = false;
					}
				else
					{
					duplicate = true;
					break;
					}
				}//end of inner for loop
			
			if(duplicate == false)
				{
				System.out.print(bGroup[i]+" ");
				}
			}//end outer for loop
	}//end union method
	/*_____________________________,
	 * method to print array values|
	 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~'
	 */
	public static void printValues(int[] array, int length)
	{
		for (int i=0; i<length; i++)			//______________________________.
		{										//|Loop that prints 1 value from|
			System.out.print(array[i] + " ");	//|array for each iteration then|
		}//end of for loop						//|advances.                    |
	}//end printValues method					//------------------------------'
} // End of ProjectThree class
