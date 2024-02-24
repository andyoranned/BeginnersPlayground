/* Name: Anne Davis
 * Date: 10/17/2022
 * Note: Modified code. Original code from Data Structures and Algorithms in JAVA
 * 
 */
public class LinkedList {
	 private Link first;            // ref to first link on list

	// -------------------------------------------------------------
	   public LinkedList()              // constructor
	      {
	      first = null;               // no links on list yet
	      }
	// -------------------------------------------------------------
	   public boolean isEmpty()       // true if list is empty
	      {
	      return (first==null);
	      }
	// -------------------------------------------------------------
	                              //get object at the beginning of list
	   public Link getFirst()
	   {
		   return first;
	   }
	//-----------------------------------------------------------------
	   public void setFirst(Link f)
	   {							//set the first to a new link
		   first = f;
	   }
	   public void insertFirst(char dd)    // insert at start of list
	      {                           // make new link
	      Link newLink = new Link( dd);
	      newLink.next = first;       // newLink --> old first
	      first = newLink;            // first --> newLink
	      }
	// -------------------------------------------------------------
	   public Link deleteFirst()      // delete first item
	      {                           // (assumes list not empty)
	      Link temp = first;          // save reference to link
	      first = first.next;         // delete it: first-->old next
	      return temp;                // return deleted link
	     }
	// -------------------------------------------------------------
	   
	   public Iterator getIterator()	//make a new iterator initialized w/ linked list
	   {
		  return new Iterator(this); 
	   }
	//----------------------------------------------------------------
	   
	   public void displayList()
	      {
	      System.out.print("List (first-->last): ");
	      Link current = first;       // start at beginning of list
	      while(current != null)      // until end of list,
	         {
	         current.displayLink();   // print data
	         current = current.next;  // move to next link
	         }
	      System.out.println("");
	      }
	// -------------------------------------------------------------
}//end LinkedList class

