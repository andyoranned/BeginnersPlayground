/*
 * Name: Anne Davis
 * Assignment: Data Structures and Algorithms 1, Project 4
 * Date: 11/05/22
 * Note: Code from Robert Lafore's, "Data Structures and Algorithms in Java."
 */
public class Link {

	   public int dData;                // data item
	   public Link next;                 // next link in list
	// -------------------------------------------------------------
	   public Link(int d)               // constructor
	      { dData = d; }
	// -------------------------------------------------------------
	   public void displayLink()         // display this link
	      { System.out.print(dData + " "); }
	// -------------------------------------------------------------
}
