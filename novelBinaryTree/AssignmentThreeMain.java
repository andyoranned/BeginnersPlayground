/* Name: Anne Davis
 * Date: April 12, 2023
 * Assignment: Assignment 3
 * 				-Build a (nearly) complete binary tree w/ size 5-20, inclusive
 * 				-Nodes must be sequential like a heap populated w/ random char value
 * 				-Operations must use BinaryTree data structure and not underlying array
 *    			
 */
import java.util.*;

public class AssignmentThreeMain {

	public static void main(String[] args) {
		int input = 0;								//stores users integer inputs
		Node tempN;									//holds temporary node value
		BinaryTree bTree;							//the Binary Tree
		boolean control = true;						//control for while loops
		Scanner kbd = new Scanner(System.in);		//to use keyboard for input
		
		while(control)
		{
			System.out.print("Size of tree, (5 - 20): ");
			
			
			input = kbd.nextInt();
			if (input < 5 || input > 20) {			//Size was outside range
				System.out.println("Invalid number\n");
				continue;							//Try again, Go back to beginning of while loop
				}
			control = false;						//Valid size, exit loop
		}
		
		bTree= new BinaryTree(input);				//Create Binary Tree, populated
		
		control = true;								//reset control to not automatically exit next loop
		
		while (control)								//menu begins
		{
													//menu prompt
			System.out.print("\n1.) Display the Binary Tree, numerical labels" +
								"\n2.) Display the Binary Tree, letters" +
								"\n3.) Build a word" +
								"\n4.) Add new node" +
								"\n5.) Displays nodes on depth" +
								"\n6.) Clear letter" +
								"\n7.) List vacant nodes" +
								"\n8.) Display the word formed at the last level" +
								"\n9.) Exit" +
								"\nSelect a numerical option: ");
			
			input = kbd.nextInt();					//user's choice
			
			switch(input)
			{
			case 1:									//display tree, numeric data
				bTree.intDisplayTree();
				
				break;
			case 2:									//display tree, character data
				bTree.chDisplayTree();
									
				break;
			case 3:								//Build a word from nodes' character data item
				bTree.wordBuilder();
								
				break;
			case 4:
				bTree.addNode();					//adds a new node, that's it 
									
				break;
			case 5:
				System.out.print("Choose a level: ");//prompt user
				input = kbd.nextInt();
				System.out.println();
				bTree.printLvl(input);				//prints the level, the code is in the tree, because it prints the tree's level, but it uses the hash table
				break;
			case 6:									//clear character data of node
				System.out.print("Enter node's numeric label: ");
				input = kbd.nextInt();
				System.out.println();
				
				if (input> bTree.getnElems()) {		//invalid input
					System.out.println("Unsuccessful: Invalid number");					
					continue;						//goto next menu loop iteration
				}
													//valid input
				tempN = bTree.findNode(input);		//get node
				tempN.clearCharData();				//clear data
				System.out.println("Successfully cleared");
				break;
			case 7:
				bTree.printCleared();			//print cleared nodes on each level				
				break;
			case 8:
				System.out.println();
				bTree.printLastLvl();				//prints chars at last level in word form
				break;
			case 9:
				control = false;
				break;
			default:
				System.out.println("Invalid Option");
			}//end switch
		}//end menu
	}//end main method
}//end AssignmentThreeMain class
