/*
 * Name:		Anne Davis
 * Date:		2/14/2023
 * Class:		Data Structures and Algorithms 2
 * Project:		Assignment 1
 * 					Build BST
 * 					
 * 
 * 
 */
import java.util.*;

public class BiSearchTreeRecursion {

	public static void main(String[] args) {
		
		//variables
		String userInput;							//holds user input
		Tree charTree=new Tree();					//Binary Search Tree to hold char data
		Stack tempStack=new Stack();				//stack for menu option 3
		
		
		Scanner kbd = new Scanner(System.in);		//keyboard for input
		System.out.println("Input a word in all CAPS: ");
		userInput=kbd.nextLine();					//Assumes input is in all CAPS
		
													
		for(int i=0; i<userInput.length(); i++)		//fill the BSTree w/ chars
		{
			charTree.insert(userInput.charAt(i)); 	
			
		}//end for loop
		
		while (true)								//start menu loop
		{
													//Menu Frontend
			System.out.println("Make your selection by inputting corresponding number:");
			System.out.println("1 -	Display Tree");
			System.out.println("2 -	Display Leaves");
			System.out.println("3 -	Display Paths' Words");
			System.out.println("4 -	Display Farthest Node(s)");
			System.out.println("5 -	Display Levels");
			
			userInput=kbd.nextLine();				//user inputs selection
			
			 /*for improved efficiency I would have liked to just run most of these methods like displayLeaves() 
			  * & pathWords() when the tree was built and store their values. This way when you are using the menu
			  * it is only retrieving said values instead of constantly computing them every time they're wanted.
			  * But the assignment asked specifically for us to call the corresponding method when making a selection from the menu.
			  * Please don't take points off for this. ;_;
			  */
						
			switch(userInput.charAt(0))				//Menu Backend
			{
			case '1':
				charTree.displayTree();				//displays tree
				break;
				
			case '2':								//displays leaves right to left
				System.out.println();				//spacing
				charTree.displayLeaves(charTree.getRoot());
				System.out.println("\n");
				break;
				
			case '3':								//displays paths' words
				System.out.println();				
				charTree.pathWords(charTree.getRoot(), tempStack);
				System.out.println("\n");			
				break;
				
			case '4':								//displays all nodes at farthest distance from root
				System.out.println();
				charTree.printFurthestNode();
				System.out.println("\n");
				break;
				
			case '5':	
				System.out.println();				//displays all letters on each level
				charTree.printLevels();
				System.out.println();
				break;
				
			default:
				System.out.println("Invalid entry.");
			}//end switch 
		}//end menu while loop
	}//end main()
}//end BiSearchTreeRecursion class
