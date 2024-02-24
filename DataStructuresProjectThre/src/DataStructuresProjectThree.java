/*
 * Name: Anne Davis
 * Date: 10/17/2022
 * Assignment: Project 3
 * 
 */
import java.util.Scanner;

public class DataStructuresProjectThree {

	public static void main(String[] args) {
		boolean menuControl=true;						//controls when menu is exited
		LinkedList charList= new LinkedList();			//new linked list
		Iterator listIterator=charList.getIterator();	//iterator to perform insert after function
		Decoder dcode=new Decoder(charList);			//object to decode with
		
		System.out.println("Enter a string of only capital letters:");//ask user for word
		
		Scanner kbd=new Scanner(System.in);
		String str= kbd.nextLine();						//get user's word(s)
		str=str.toUpperCase();							//convert to upper case in case user used lowercase
		
		for (int i=0; i<str.length(); i++)				//fill linked list w/ chars from input
		{
			listIterator.insertAfter(str.charAt(i));
		}//end for loop
		
		//menu
		while (menuControl==true)						//keep offering menu until user exits
		{
			System.out.println("Enter number of operation you want to perform:");	//display menu choices
			System.out.println("1.)   Decode list based on the outlined rules.");
			System.out.println("2.)   Remove consecutive duplicate letters.");
			System.out.println("3.)   Exit");
			
			str=kbd.nextLine();							//get user's selection choice
			char switchControl=str.charAt(0);			//turn into a character
			
			switch(switchControl)						//menu functionality
			{
			case '1':
														//decode based on sequences
				dcode.decode();
				break;
			case '2':
				dcode.removeDuplicate();				//remove duplicates from the list
				break;
			case '3':
				menuControl=false;						//exit menu
				break;
			default:
				System.out.println("Please enter a valid number.");					
			}//end switch
		}//end menu while loop
		kbd.close();									//close scanner object
	}//end main method
}//end DataStructuresProjectThree class
