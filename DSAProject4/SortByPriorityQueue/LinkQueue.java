/*
 * Name: Anne Davis
 * Assignment: Data Structures and Algorithms 1, Project 4
 * Date: 11/05/22
 * Note: Modified code from Robert Lafore's, "Data Structures and Algorithms in Java."
 */
public class LinkQueue {

	   private LinkedList theList;		//linked list to implement the priority queue with
	   private int nItems;				//keeps track of how many items are in the queue
	//--------------------------------------------------------------
	   public LinkQueue()                // constructor
	      { theList = new LinkedList(); // make a linked list
	        nItems=0;					//no items in p-queue yet
	      }  
	//--------------------------------------------------------------
	   public boolean isEmpty()          // true if queue is empty
	      { 
		   if (nItems<=0)
			   return true;
		   return false;
		  }
	//--------------------------------------------------------------
	   public void enqueue(int item)        // insert with priority
	      {
		   theList.insertPriority(item);
		   nItems++;
	      }
	//--------------------------------------------------------------
	   public int dequeue()              // remove, front of queue
	      {
		   int temp=theList.deleteFirst();
		   nItems--;
		   return temp;  
	      }
	//--------------------------------------------------------------
	 
	   public int getNItems()			//return how many elements are in the queue
	   	  { 
		   return nItems;
	   	  }
	//--------------------------------------------------------------
	  
	////////////////////////////////////////////////////////////////

	
}//end class
