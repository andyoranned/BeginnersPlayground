/* Name: Anne Davis
 * Date: April 12, 2023
 * Assignment: Assignment 3
 * 
 */


public class Node {
	   private int iData;               // Number data item, KEY
	   private char charData;           // Capital Character data item
	   private Node leftChild;          // this node's left child
	   private Node rightChild;			// this node's right child
	   private Node parent;				//node's parent

	   //Constructor~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	   public Node(int i) {
		   iData = i+1;					//save key
		   randomLetter();				//generate random capital letter and save to charData
	   }
	   
	   //Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 
	   //getters for fields
	   public Node getLeftChild() {
		   return leftChild;}
	   
	   public Node getRightChild() {
		   return rightChild;}
	   
	   public Node getParent() {
		   return parent;}
	   
	   public char getCh() {
		   return charData;
	   }
	   
	   public int getInt() {
		   return iData;
	   }
	   
	   //setters for fields
	   
	   public void setLeftChild(Node c) {
		   this.leftChild = c;
	   }
	   
	   public void setRightChild(Node c) {
		   this.rightChild = c;
	   }
	   
	   public void setParent(Node p) {
		   this.parent = p;
	   }
	   
	   //Clear character data item
	   public void clearCharData() {
		   this.charData = ' ';
	   }
	   
	  //generate random capital letter and save to charData
	   public void randomLetter() {		   
		   int randomInt = 65 + (int)(Math.random() * ((90 - 65) + 1)); //random number between 65-90
		   charData = (char)randomInt;									//Cast int to character
	   }
}//end Node class
