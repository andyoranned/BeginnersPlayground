/* Name: Anne Davis
 * Date: April 12, 2023
 * Assignment: Assignment 3
 * Notes:	Code adapted from Robert Lafore's
 * 			Data Structures and Algorithms in Java
 * 			is designated with a '-' bar. 
 * 			Anne's code designated with a '~' bar 
 */


import java.util.*;

public class BinaryTree {
	//fields
	private Node root;
	private Node[] treeArray;				//array to hold Binary Tree
	private int arraySize = 20;				//Size of the underlying array
	private int nElems;						//Number of elements in tree
	private HashTable paths;				//holds the directions to nodes
	
	//constructor~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public BinaryTree(int totalToAdd) {	
		paths = new HashTable();			//create hash table
		treeArray = new Node[arraySize];	//create array to hold tree's nodes
		
		
		for (int i=0; i<totalToAdd; i++) {	//populate tree
			
			treeArray[nElems] = new Node(i); //add new node to tree
			
			
			if (nElems == 0)				//Is it the root?
				root = treeArray[nElems];				
			else {							//For everything that's not the root
				int parentIndex=(i-1)/2;
				treeArray[i].setParent(treeArray[parentIndex]);			// set parent field
				
				   
				  int temp = 2 * parentIndex + 1; //calculate parent's leftChild's index
				 
				  if (temp == i)					//this node a right or left child?
					  treeArray[parentIndex].setLeftChild(treeArray[i]);//update parent's field to reflect this
				  else
					  treeArray[parentIndex].setRightChild(treeArray[i]);
				  }//end outer if-statement	
			
			
			paths.insert(treeArray[nElems]);			//Add directions to Node to Hash Table
			
			nElems++;									//add to the running total of elements
			
		}//end for loop
	}//end constructor
	
	//methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public int getnElems() {							//get nElems
		return nElems;
	}
	
	public void addNode() {
		
		if (nElems == arraySize) {						//check for space, if none display message and return to menu
			System.out.println("Unsuccessful Add: Tree is full");
			return;
		}
		
		Node temp = new Node((nElems));					//Node created
		paths.insert(temp);								//Hash it
		
		String str = paths.getPathData(temp);			//Get directions to how to get to where it belongs
		
		Node current = root; 							//start at the root
		
		
		for (int i=0; i<(str.length()-1); i++) {		//work down the tree to new node's parent
			if (str.charAt(i) == '1')
				current=current.getRightChild();
			else
				current = current.getLeftChild();				
		}
		
		if (str.charAt(str.length() - 1) == '1') 		//connect new node to appropriate child slot of it's parent
			current.setRightChild(temp);
		else
			current.setLeftChild(temp);
		
		temp.setParent(current);						//connect new node to it's parent
			
		nElems++;										//increase count of elements
		
		System.out.println("Successful Add");
	}//end addNode()
	
	public void printLvl(int lvl) {
		String str = paths.getPathData(nElems);			//get directions to last Node from Hash Table
		int maxLvl = str.length();						//How long is it? = How many levels
		
		if (lvl > maxLvl) {								//validate user input
			System.out.println("Unsuccessful: Level does not exist");
			return;										//return to menu
		}
		
		int start = (int)(2* (Math.pow(2, (lvl-1)))); 	//starting point of the level
		int end = (int)(2* (Math.pow(2, (lvl))) - 1);	//ending point
		int counter = start;							//counts how many empty nodes 
		
		System.out.printf("Nodes on level %d: ", lvl);
		
		
		while(counter<=nElems && counter<=end) {		//print all numbers on level ending early if reach total nodes
			System.out.print(counter + " ");
			counter++;
		}	
	}//end printLvl()
	
	public void printLastLvl() {
		
		int maxLvl = paths.getPathData(nElems).length();	//Last level
		int start = (int)(2* (Math.pow(2, (maxLvl-1)))); 	//starting point of the level
		int counter = start;						
		
		System.out.print("Word formed on last level: ");
		
		while (counter <= nElems) {							//Go through each node on the level
			Node tempN = findNode(counter);		
			char tempCh = tempN.getCh();
			
			if (tempCh == ' ')								//if deleted, do special formatting
				System.out.print("[ ]");
			else
				System.out.print(tempCh);					//print character
			counter++;
		}
		System.out.println();
	}//end printLastLvl()
	
	public Node findNode(int n) {		
		
		
		
		String str = paths.getPathData(n);					//Get directions to node
		if (str.equals("3"))
			return root;
		
		Node current = root; 								//start at the root
		
		for (int i=0; i<str.length(); i++) {				//work down the tree to node
			if (str.charAt(i) == '1')
				current = current.getRightChild();
			else
				current = current.getLeftChild();
		}
		return current;
	}//end findNode()
	
	
	//You're killing me here! It's so much easier/efficient using a stack & queue. But noooo have to require the use of the hash table to traverse the tree and visit nodes like a million times. What is this monstrosity!! :) 
	public void printCleared() {
		double maxNodesLvl = 0;								//maximum nodes on level
		int nTotal = 0;										//total nodes evaluated
		
		int maxLvl = paths.getPathData(nElems).length();	//Last level
		
		System.out.println("\nThe vacancies:\n");
		
		for(int i=0; i<=maxLvl; i++) {					//outer loop controls current level
			maxNodesLvl = Math.pow(2, i);
			int vacant = 0;								//number of vacancies on level
			int nLvlEval = 0;							//count nodes examined on level
			while (nTotal<nElems && nLvlEval<maxNodesLvl) {//iterate through all nodes on level
				nTotal++;								//get nTotal to match with index in hashtable&node numercial data
				Node temp = findNode(nTotal);			//get to node via hashtable
				if (temp.getCh() == ' ') {				//Is it cleared?
					System.out.printf("#%d ",temp.getInt());//print it
					vacant++;
				}
				
				nLvlEval++;								//finished evaluating another node
			}//end while loop
			
			if (vacant != 0)							//Only print formating if vacancies found on level
				System.out.print(": ");
			System.out.printf("%d on level %d\n", vacant, i);//Print count on level
		}//end for loop outer		
	}//end printCleared()

	public void wordBuilder () {
		System.out.print("Enter the size of the word: ");
		Scanner kbd = new Scanner(System.in);
		int wLength = kbd.nextInt();
		System.out.println();
		System.out.println("Input the nodes' numeric value one at a time. Press [ENTER] after each");
		StringBuilder strBld = new StringBuilder();
		
		for(int i=0; i<wLength; i++) {
			int tempI=0;
			while (true) {								//repeats until valid node is entered
				System.out.print("Node value: ");			
				tempI = kbd.nextInt();
				if (tempI<=nElems)						//valid? Leave while loop
					break;
				System.out.println("\nInvalid node, try another");				
			}
			
			
			Node tempN=findNode(tempI);					//locate node
			char tempCh = tempN.getCh();				//get its character data item
			
			if (tempCh == ' ')							//if deleted, do special formatting
				strBld.append("[ ]");
			else
				strBld.append(tempCh);					//append character to string
		}//end forloop
		
		System.out.print("Resulting word: ");
		System.out.println(strBld.toString());		
	}//end wordBuilder()
	
	// Modified Lafore code-------------------------------------------------------------
	   public void chDisplayTree()
	      {
	      Stack globalStack = new Stack();
	      globalStack.push(root);
	      int nBlanks = 32;
	      boolean isRowEmpty = false;
	      System.out.println(
	      "......................................................");
	      while(isRowEmpty==false)
	         {
	         Stack localStack = new Stack();
	         isRowEmpty = true;

	         for(int j=0; j<nBlanks; j++)
	            System.out.print(' ');

	         while(globalStack.isEmpty()==false)
	            {
	            Node temp = (Node)globalStack.pop();
	            if(temp != null)
	               {
	            	if (temp.getCh() == ' ')			//Added to check for cleared nodes~~~~~~~
	            		System.out.print("[ ]");
	            	else
	            		System.out.print(temp.getCh());	//End Anne's modifications~~~~
	               
	               localStack.push(temp.getLeftChild());
	               localStack.push(temp.getRightChild());

	               if(temp.getLeftChild() != null ||
	                                   temp.getRightChild() != null)
	                  isRowEmpty = false;
	               }
	            else
	               {
	               System.out.print("--");
	               localStack.push(null);
	               localStack.push(null);
	               }
	            for(int j=0; j<nBlanks*2-2; j++)
	               System.out.print(' ');
	            }  // end while globalStack not empty
	         System.out.println();
	         nBlanks /= 2;
	         while(localStack.isEmpty()==false)
	            globalStack.push( localStack.pop() );
	         }  // end while isRowEmpty is false
	      System.out.println(
	      "......................................................");
	      }  // end chDisplayTree()
	// -------------------------------------------------------------
	
	   public void intDisplayTree()
	      {
	      Stack globalStack = new Stack();
	      globalStack.push(root);
	      int nBlanks = 32;
	      boolean isRowEmpty = false;
	      System.out.println(
	      "......................................................");
	      while(isRowEmpty==false)
	         {
	         Stack localStack = new Stack();
	         isRowEmpty = true;

	         for(int j=0; j<nBlanks; j++)
	            System.out.print(' ');

	         while(globalStack.isEmpty()==false)
	            {
	            Node temp = (Node)globalStack.pop();
	            if(temp != null)
	               {
	               System.out.print(temp.getInt());
	               
	               localStack.push(temp.getLeftChild());
	               localStack.push(temp.getRightChild());

	               if(temp.getLeftChild() != null ||
	                                   temp.getRightChild() != null)
	                  isRowEmpty = false;
	               }
	            else
	               {
	               System.out.print("--");
	               localStack.push(null);
	               localStack.push(null);
	               }
	            for(int j=0; j<nBlanks*2-2; j++)
	               System.out.print(' ');
	            }  // end while globalStack not empty
	         System.out.println();
	         nBlanks /= 2;
	         while(localStack.isEmpty()==false)
	            globalStack.push( localStack.pop() );
	         }  // end while isRowEmpty is false
	      System.out.println(
	      "......................................................");
	      }  // end intDisplayTree()
	// -------------------------------------------------------------
}//end BinaryTree class
