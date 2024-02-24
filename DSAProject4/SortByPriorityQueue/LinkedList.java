	/* Name: Anne Davis
	 * Date: 10/17/2022
	 * Note: Modified code. Original code from Data Structures and Algorithms in JAVA
	 * 
	 */

public class LinkedList {
	
		 private Link first;            // ref to first link on list

		// -------------------------------------------------------------
		   public LinkedList()         // constructor
		      {
		      first = null;            // no links on list yet
		      }
		// -------------------------------------------------------------
		   public boolean isEmpty()    // true if list is empty
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
		   //--------------------------------------------------------------
		   public void insertFirst(int dd)    // insert at start of list
		      {                           // make new link
		      Link newLink = new Link( dd);
		      newLink.next = first;       // newLink --> old first
		      first = newLink;            // first --> newLink
		      }
		// -------------------------------------------------------------
		   public int deleteFirst()        // delete first item
		     {   
			   Link temp = first;      // save reference to link
			   first = first.next;     // delete it: first-->old next
			   return temp.dData;      // return deleted link's data   
		     }
		// -------------------------------------------------------------
		   
		   public void insertPriority(int item) // insert so that items are in ascending order
		      { 
			   Link newLink= new Link(item);	//make a new link to be added to queue
			   Link previous=null;				//keep track of last link
			   Link current=first;				//walker to traverse list
			   
			   while(current!=null && item>current.dData) //walk the list until location is found
			   {
				   previous=current;
				   current=current.next;
			   }
			   if (previous==null)		//if we never walked the list....
			   {
				   first=newLink;		//then it's spot is at the beginning
			   }
			   else
			   {
				   previous.next=newLink;	//otherwise, it's spot is after previous
			   }
			   newLink.next=current; 	//newLink->current
		      }//end insertPriority

}//end linked list
