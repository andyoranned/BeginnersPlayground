
public class test {

	public static void main(String[] args) {
		int tempInt1;
		int tempInt2;
		String tempString= "";
		

	    String[] stringArray = {"Honey Ham", "Reindeer Games", "Christmas Tree", "Sugar Cookies", "New Year's Eve"};  
	    
		int randString = (int)(Math.random()*stringArray.length);
		System.out.println("randString=" + randString);
		

        for (int i=0; i<=(stringArray[randString].length()/2); i++)                                 //for loop to scramble characters of the string stringArray[randString]
        {
            /* do-while loop ensures tempInt1 is not larger than or equal to
             * tempInt2 so that there is not a runtime error during scramble
             * operations.
             */
            do {
                tempInt1 = (int)(Math.random()*stringArray[randString].length());               //assign random value to represent position in String to be swapped
                tempInt2 = (int)(Math.random()*stringArray[randString].length());
            }while(tempInt1>=tempInt2);

            //SCRAMBLE OPERATIONS
            tempString = stringArray[randString].substring(0, tempInt1);  
            System.out.println(tempString);
            
            //front of string to letter in position designated by tempInt1 added to tempString
            tempString = tempString + stringArray[randString].substring(tempInt2, tempInt2+1);  //letter designated by tempInt2 replaces letter originally in tempInt1 position
            System.out.println(tempString);
            tempString = tempString + stringArray[randString].substring(tempInt1+1, tempInt2);  //Substring between two swapped letters is add to tempString
            System.out.println(tempString);
            tempString = tempString + stringArray[randString].substring(tempInt1, tempInt1+1);  //letter designated by tempInt1 replaces letter originally in tempInt2 position
            System.out.println(tempString);
            tempString += stringArray[randString].substring(tempInt2+1, stringArray[randString].length());  //remaining substring beyond tempInt2's position is added to tempString
            System.out.println(tempString);
        }//end for loop for scrambling
	
		}

	}
