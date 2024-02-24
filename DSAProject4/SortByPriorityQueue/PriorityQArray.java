/*
 * Name: Anne Davis
 * Assignment: Data Structures and Algorithms 1, Project 4
 * Date: 11/05/22
 * Note: Modified code from Robert Lafore's, "Data Structures and Algorithms in Java."
 */	
public class PriorityQArray {
		private PriorityQList[] a;			// array of priority queues                
	   //-----------------------------------------------------------
	   public PriorityQArray(int max)       // constructor
	      {
		   a= new PriorityQList[max];		//make new array
	      }
	   //-----------------------------------------------------------
	   public boolean isEmpty(int index)	//is this element empty?
	   {
		   return (a[index]==null);
	   }
	   //-------------------------------------------------------------
	   public void insert(int item) 		//insert element in corresponding index
	   {
		   int i = (int) item/10;			//determine index where item belongs
		   
		   if (a[i]==null)					//if this index is empty...
		   {
			   a[i]=new PriorityQList();	//make a new pQueue for it
		   }
		  a[i].enqueue(item);				//add the item to queue
	   }
	   //--------------------------------------------------------------
	   public int getElem(int index)		 //get the value stored next in the queue
	   {
		   if (a[index].getNItems()==0) 	//if it's empty
		   {
			   return -1;					//return sentinel value
		   }
		   return a[index].dequeue();		//otherwise dequeue from priority queue  	   
	   }//end getElem method
}//end priorityQArray class
