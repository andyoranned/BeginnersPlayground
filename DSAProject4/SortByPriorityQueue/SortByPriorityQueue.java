/*
 * Name: Anne Davis
 * Assignment: Project 4
 * Date: 11/04/2022
 */
public class SortByPriorityQueue {

	public static void main(String[] args) {
		int intArraySize = 200;							//size of the integer array
		int pQArraySize=11;								//size of priority queue array
		IntArray numbers= new IntArray(intArraySize);	//array of random integers
		PriorityQArray pQArray= new PriorityQArray(pQArraySize); //priority queue array. 
		
		System.out.print("Integer array's initial order: \t{");
		
		for(int i=0; i<intArraySize; i++)     			// for each element of integer array
		{
			numbers.insert((int)(Math.random() * 101));	//populate array with random numbers between 0-100
			if (i==intArraySize-1)
				System.out.print(numbers.getElem(i) + ". ");
			else
				System.out.print(numbers.getElem(i) + ", ");// display with formatting
			pQArray.insert(numbers.getElem(i));			//enqueue value to priority queues
		}
	    
		System.out.println("}");						//closing formatting
	      
		numbers.reset();								//start integer array from beginning for overwriting values
		
		for(int i=0; i<pQArraySize;i++)					//for every element of the array of priority queues...
		{
			while (!pQArray.isEmpty(i))					//for every element in the priority queue...
			{
				int temp=pQArray.getElem(i);			//dequeue, and hold onto integer stored in link
				if (temp==-1)							//if sentinel, don't record
				{
					break;								//leave loop
				}
				numbers.insert(temp);					//otherwise add to integer array
			}//end while
		}//end for loop
		pQArray=null;									//done with priority queues, delete array
	    
		System.out.print("Integer array's final order: \t{");
		numbers.display();								//print the integer array
		System.out.print("}");
	}//end main method
}//end sortbypriority class
