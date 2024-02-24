/* Name: Anne Davis
 * Date: 10/17/2022
 * Note: Modified code. Original code from Data Structures and Algorithms in JAVA
 * 
 */
public class Link {
	
	   public char letter;              // data item
	  
	   public Link next;              // next link in list
	// -------------------------------------------------------------
	   public Link(char ch) // constructor
	      {
	      letter=ch;                 // initialize data
	      							// ('next' is automatically
	      }                           //  set to null)
	// -------------------------------------------------------------
	   public void displayLink()      // display ourself
	      {
	      System.out.print("{" + letter + "} ");
	      }
	   }  // end class Link
	////////////////////////////////////////////////////////////////