package my_string_project;


//**
//* Topic: Java Character and Java String
//

import java.util.*;
public class MyString {

	public static void main(String[] args) {
		// declare string object
		String text = ""; //initialized with empty string
		//prompt the user
		System.out.printf("Please enter a text", args);
		//create scanner object
		Scanner kbd = new Scanner(System.in);
		text = kbd.next();
		
		//perform different operations
		System.out.println("length = " + text.length());
		//convert to uppercase
		System.out.println("value = " + text.toUpperCase());
		
		
		//determine location of a character
		int index = text.indexOf('B');
		System.out.println("index =" + index);
		//determine location of substring
		index = text.indexOf("abc");
		System.out.println("\"abc\" is located at: " + index);
		
		//search function
		boolean status = text.contains("ab");
		System.out.println("status :" + status);

	}

}
