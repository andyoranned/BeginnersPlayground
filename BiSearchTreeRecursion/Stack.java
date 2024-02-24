/*
 * Name:	Anne Davis
 * Notes:	Code adapted from Robert Lafore's taken from 
 * 			Data Structures and Algorithms in Java. 
 * 			Added code designated with a '~' bar 
 */

class Stack
   {
   private LinkList theList;
//--------------------------------------------------------------
   public Stack()             // constructor
      {
      theList = new LinkList();
      }
   
 //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Anne's Method
   
   public void recursiveStackPrint()
   {
	   if (isEmpty())						//base case
		   return;
	   Node temp=pop();						//remember popped node
	   System.out.print(temp.letter);		//print it's letter
	   recursiveStackPrint();				//repeat for all letters
	   push(temp);							//put the Node back  
   }//end recursiveStackPrint()
  
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~End Anne's Method   
   
//--------------------------------------------------------------
   public void push(Node j)     // put item on top of stack
      {
      theList.insertFirst(j);
      }
//--------------------------------------------------------------
   public Node pop()            // take item from top of stack
      {
      return theList.deleteFirst();
      }
//--------------------------------------------------------------
   public boolean isEmpty()       // true if stack is empty
      {
      return ( theList.isEmpty() );
      }
   }  // end class LinkStack
////////////////////////////////////////////////////////////////

