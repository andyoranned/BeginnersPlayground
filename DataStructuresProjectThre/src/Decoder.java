/*
 * Name: Anne Davis
 */
public class Decoder {
  //--------------------------------------------------------------------Fields	
	private LinkedList ourList;
	private Iterator listIterator;
	
 //--------------------------------------------------------------------Constructor	
	
	public Decoder(LinkedList list)
	{
		ourList=list;
		listIterator= new Iterator(ourList);
	}//end constructor
//-----------------------------------------------------------------------Methods------------------	
	 public void decode()
		{
		   boolean isOperation;						//controls do-while loop
			do										//test if conditions are met & then perform operations
			{
				listIterator.reset();
				isOperation=false;
				if(listIterator.getCurrentNextX(1)!=null)//if list isn't empty
				{
				while(listIterator.getCurrentNextX(2) != null)//terminate when there's not enough letters left in list to perform operations
				{
					Link temp=listIterator.getCurrent();
					switch(temp.letter)
					{
					case 'S':
						if (temp.next.letter=='P')	//Need to swap?
						{
							swap();					//swap letters after SP and delete SP
							isOperation=true;
						}//end outer if under case S
						break;
					case 'R':
						if (temp.next.letter=='M')	//is there RM sequence?	
						{
							remove();				//remove the three objects from list
							isOperation=true;
						}
						break;
					case 'D':
						if (temp.next.letter=='D')	//is there DD sequence?
						{
							doubleDown();
							isOperation=true;
						}
						break;
					default:						//no sequences, then do nothing
						break;
					}//end switch
					 listIterator.nextLink();		//advance down the list.
				}//end while loop
				}//end if statement listIterator not null
			}while(isOperation==true);			//if there was a sequence last time, enter loop
			ourList.displayList();				//print results
		}//end decode method
	//---------------------------------------------------------------------------------------------------------------------
	
	//swap letters after SP and delete SP
	public void swap()	
	{		
		if(listIterator.getCurrentNextX(3)!=null)	//is there two letter after SP?
		{
			Link swapToFirstPosition=listIterator.getCurrentNextX(3);	//give it a name so there's not so many .next's
			Link swapToSecondPosition=listIterator.getCurrentNextX(2);
		
			listIterator.getPrevious().next= swapToFirstPosition;		//put the last letter in sequence in first place
			swapToSecondPosition.next=swapToFirstPosition.next;			//have the new last letter point to the correct object
			swapToFirstPosition.next=swapToSecondPosition;				//update the .next of the object that's now first
			
			listIterator.setCurrent(swapToSecondPosition);				//update current
		}//end if
	}//end swap method
	//-----------------------------------------------------------------------------------------------------------------------
	
	//remove RM and the letter after
	public void remove()
	{
		Link afterRMLetter=listIterator.getCurrentNextX(2);		//assign an easy to read name
		listIterator.getPrevious().next=afterRMLetter.next;		//delete
		listIterator.setCurrent(afterRMLetter.next);			//update current
	}//end remove method
	//------------------------------------------------------------------------------------------------------------------------

	//Remove DD and duplicate the character after the sequence
	public void doubleDown()
	{
		Link afterLastD=listIterator.getCurrentNextX(2);		//assign easy to read name
		Link duplicate=new Link(afterLastD.letter);				//make a new link duplicating corresponding char value
		
		listIterator.getPrevious().next=afterLastD;				//delete double D's
		listIterator.setCurrent(afterLastD);					//update current
																//insert the duplicated link
		duplicate.next=listIterator.getCurrent().next;			//dplicate=>current.next
		listIterator.getCurrent().next=duplicate;				//current.next=>>duplicate
				
	}//end doubleDown method
	//------------------------------------------------------------------------------------------------------------------------
	
	//Remove any duplicates so that only one remains
	public void removeDuplicate()
	{
		boolean isOperation;
		do
		{
			listIterator.reset();							//start iterator from beginning of list
			isOperation=false;								//no operations in this iteration, yet
			while(listIterator.getCurrentNextX(2)!=null)
			{
				if (listIterator.getCurrent().letter==listIterator.getCurrentNextX(1).letter) //if duplicate
				{
					isOperation=true;						//yes, there's an operation in this iteration
					listIterator.deleteCurrent();			//delete the duplicate	
				}
				else										//if not duplicate
				{	
					listIterator.nextLink();				//only advance down the list						
				}
				//end if
			}//end while loop
		}while(isOperation);
		ourList.displayList();								//print the results when done processing
	}
}//end decoder class
