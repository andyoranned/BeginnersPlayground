
/* Name: Anne Davis
 * Assignment: Data Structures and Algorithms 1, Project 4
 * Date: 11/05/22
 * Note: Modified code from Robert Lafore's, "Data Structures and Algorithms in Java."
 */

public class IntArray {
	   private int[] a;                 // ref to array a
	   private int nElems;               // number of data items
	   //-----------------------------------------------------------
	   public IntArray(int max)         // constructor
	      {
	      a = new int[max];             // create the array
	      nElems = 0;                   // no items yet
	      }
	   //-----------------------------------------------------------
	   public void insert(int value)    // put element into array
	      {
	      a[nElems] = value;            // insert it
	      nElems++;                     // increment size
	      }
	   //-----------------------------------------------------------
	   public boolean delete(int value)
	      {
	      int j;
	      for(j=0; j<nElems; j++)       // look for it
	         if( value == a[j] )
	            break;
	      if(j==nElems)                 // can't find it
	         return false;
	      else                          // found it
	         {
	         for(int k=j; k<nElems; k++)// move higher ones down
	            a[k] = a[k+1];
	         nElems--;                  // decrement size
	         return true;
	         }
	      }  // end delete()
	   //-----------------------------------------------------------
	   public void display()            // displays array contents
	      {
	      for(int j=0; j<nElems; j++)   // for each element,
	    	  if (j==nElems-1)
	    		  System.out.print(a[j] + ". ");
	    	  else
	    		  System.out.print(a[j] + ", ");// display it
	      }
	   //-----------------------------------------------------------
	   public int totalElems()			//get the number of elements in the array
	   {
		   return nElems;
	   }
	   //------------------------------------------------------------
	   public int getElem (int index) //get the element at the specified index
	   {
		   return a[index];
	   }
	   //-------------------------------------------------------------
	   public void reset()				//reset the count of elements
	   {
		   nElems=0;
	   }
}//end intArray class
