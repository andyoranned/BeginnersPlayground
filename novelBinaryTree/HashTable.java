/* Name: Anne Davis
 * Date: April 12, 2023
 * Assignment: Assignment 3
 */

public class HashTable {
	
	//fields~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private String[] array;						//holds the data
	private int arraySize = 21;					//max size allowed + 1 to account for empty array[0], no need to shrink to fit small size and risk rehashing when user adds more
	private int nElems;
	//constructor~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public HashTable () {							
		array = new String[arraySize];			
	}

	//methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public void insert (Node iNode) {
		int i = iNode.getInt();								//value of Node's key
		
		
		if (i == 1) {									
			array[i] = String.valueOf(3);					//root? Flag it w/ decimal number
			nElems++;
			return;											//skip calculating path
		}
		
		StringBuilder strPath = new StringBuilder();		//To hold accumulated directions
		recBiPath(i, strPath);								//calculate directions to node to store
		
		array[i] = strPath.toString();						//Save directions in HashTable(direct addressing)
		nElems++;
	}//end insert()
	
	public void recBiPath (int i, StringBuilder str) {
		if (i == 0)											//Base case, nothing left to divide
			return;
		
		int iWhichChild = i % 2;							//Do I turn left(0) or right(1)?
		
		i/=2;												
		
		recBiPath(i, str);									//Calculate next directions
		
		if (i == 0)											//do not save the first value
			return;
		
		str.append(iWhichChild);							//Add the numerical representation of direction to end of stringbuilder
	}//end recBiPath()
	
	public String getPathData(Node n) {						//get the path to node stored in hash table
		return array[n.getInt()];
	}
	public String getPathData(int i) {
		return array[i];
	}
}//end HashTable class
