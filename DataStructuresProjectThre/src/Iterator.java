/* Name: Anne Davis
 * Date: 10/17/2022
 * Note: Modified code. Original code from Data Structures and Algorithms in JAVA
 * 
 */

public class Iterator {
	
	   private Link current;          // current link
	   private Link previous;         // previous link
	   private LinkedList ourList;      // our linked list
	//--------------------------------------------------------------
	   public Iterator(LinkedList list) // constructor
	      {
	      ourList = list;
	      reset();
	      }
	//--------------------------------------------------------------
	   public void reset()            // start at 'first'
	      {
	      current = ourList.getFirst();
	      previous = null;
	      }
	//--------------------------------------------------------------
	   public boolean atEnd()         // true if last link
	      { return (current.next==null); }
	//--------------------------------------------------------------
	   public void nextLink()         // go to next link
	      {
	      previous = current;
	      current = current.next;
	      }
	//--------------------------------------------------------------
	   public Link getCurrent()       // get current link
	      { return current; }
	//--------------------------------------------------------------
	   public void setCurrent(Link newCurrent)
	   {
		   current=newCurrent;		//current becomes method call's argument
	   }
	 //--------------------------------------------------------------  
	   public Link getCurrentNextX(int numberOfNexts) //returns current.next with up to three nexts.
	   {
		   switch(numberOfNexts)
		   {
		   case 1:
			   return current.next;
		   case 2:
			   return current.next.next;
		   case 3:
			   return current.next.next.next;
		   default:
				return null;  
		   }//end switch
	   }//end currentNext method
	 //----------------------------------------------------------------
	   public Link getPrevious()
	   {
		   return previous;					//returns the value in previous
	   }
	 //-------------------------------------------------------------------  
	   public void insertAfter(char dd)     // insert after
	      {                                 // current link
	      Link newLink = new Link(dd);

	      if( ourList.isEmpty() )     // empty list
	         {
	         ourList.setFirst(newLink);
	         current = newLink;
	         }
	      else                        // not empty
	         {
	         newLink.next = current.next;
	         current.next = newLink;
	         nextLink();              // point to new link
	         }
	      }
	//--------------------------------------------------------------
	   public void insertBefore(char dd)    // insert before
	      {                                 // current link
	      Link newLink = new Link(dd);

	      if(previous == null)        // beginning of list
	         {                        // (or empty list)
	         newLink.next = ourList.getFirst();
	         ourList.setFirst(newLink);
	         reset();
	         }
	      else                        // not beginning
	         {
	         newLink.next = previous.next;
	         previous.next = newLink;
	         current = newLink;
	         }
	      }
	//--------------------------------------------------------------
	   public void deleteCurrent()    // delete item at current
	      {
	      
	      if(previous == null)        // beginning of list
	         {
	         ourList.setFirst(current.next);
	         reset();
	         }
	      else                        // not beginning
	         {
	         previous.next = current.next;
	         if( atEnd() )
	            reset();
	         else
	            current = current.next;
	         }
	      }
		//--------------------------------------------------------------
	   }  // end class Iterator
	////////////////////////////////////////////////////////////////