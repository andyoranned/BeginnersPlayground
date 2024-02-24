package assignment_statement_project;

//
import java.util.*;

public class AssignmentStatements {

	public static void main(String[] args) {
		// declares some var
		double x = 0, y = 0, z = 0;
		String sx = "", sy = "";
		
		//create scanner obj
		Scanner kbd = new Scanner(System.in);
		//prompt user
		System.out.printf("%s :", "Please enter two numbers");
		sx = kbd.next();
		sy = kbd.next();
		
		//perform conversion from a string into a number
		x = Double.parseDouble(sx);
		y = Double.parseDouble(sy);
		
		//turn a number into a string object where 'temp' is of your choice
		String temp = "" + x;
		
		//assignment statement
		z = x + y;
		System.out.printf("%f + %f = %f\n",x,y,z);
		System.out.println(x + " + " + y + " = " + z);
		
		//verify the size of primitive data type
		System.out.println("long size = " + Long.BYTES);
		
		//modulus operator
		int x = 11, y = 2, z = 0;
		//check if x is even or odd
		z = x % y;
		//use conditional statement to determine if z is 1 or 0
		if (z==0) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
	

	}

}
