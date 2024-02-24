/* File		: Program.java
 * Date		: 01/25/2021
 * Author	:Anne
 * ...
 */

import java.util.Scanner;

/* -- Prompt the user
 * -- Read a number from kbd
 * --determine if the number is negative or positive.
 * --Show result
 */

public class Program {
	int i = 0 ;
	
		//entry point for program execution
	public static void main(String[] args) {
		//prompt the user
		System.out.println("Please enter a number!");
		// Create scanner instance/object
		Scanner kbd = new Scanner(System.in);
		// declare an integer variable
		int x = 0;
		//named memory space with integer property
		//perform java input operation
		x = kbd.nextInt();
		//increment x
		x = x + 1;
		//display something
		System.out.println("x = " + x);
		
	
	}

}
