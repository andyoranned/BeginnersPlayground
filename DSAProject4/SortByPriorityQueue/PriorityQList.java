/*
 * Name: Anne Davis
 * Assignment: Data Structures and Algorithms 1, Project 4
 * Date: 11/05/22
 * Note: Modified code from Robert Lafore's, "Data Structures and Algorithms in Java."
 */	
public class PriorityQList {
	
	   private Link first;					//first link in priority queue 
	   private int nItems;					//keeps track of how many items are in the queue
	   
	//--------------------------------------------------------------
	   public PriorityQList()               // constructor
	      { 
		   first=null; 						//no items in p-queue yet
	      }  
	//--------------------------------------------------------------
	   public boolean isEmpty()          	// true if queue is empty
	      { 
		   return (first==null);
		  }
	//--------------------------------------------------------------
	   public void enqueue(int item)        // insert with priority
	      {
		   Link newLink= new Link(item);	//make a new link to be added to queue
		   Link previous=null;				//keep track of the last link traversed
		   Link current=first;				//walker to traverse list
		   
		   while(current!=null && item>=current.dData) //walk the list until location is found
		   {
			   previous=current;
			   current=current.next;
		   }
		   
		   if (previous==null)				//if we never walked the list....
		   {
			   first=newLink;				//then it's spot is at the beginning
		   }
		   else
		   {
			   previous.next=newLink;		//otherwise, it's spot is after previous
		   }
		   newLink.next=current; 			//newLink->current
		   nItems++;
	      }
	//--------------------------------------------------------------
	   public int dequeue()              	// remove, front of queue
	      {
		   int temp = first.dData;  		// save data from link
		   first = first.next;  			// delete it: first-->old next
		   nItems--;						//decrement count of items in queue
		   return temp;     	 			// return deleted link's data   
	      }
	//--------------------------------------------------------------
	   public int getNItems()				//return how many elements are in the queue
	   	  { 
		   return nItems;
	   	  }
	//--------------------------------------------------------------
}//end priorityQList class
