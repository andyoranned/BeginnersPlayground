package assignmentoperator;
import java.util.Random;
import java.util.Scanner;


public class assignmentop {

	public static void main(String[] args) {
		char ch = ' ';
		//create a Scanner object
		Scanner kbd = new Scanner(System.in);
		//promt user
		System.out.println("Please enter a character");
		//read a char from kbd
		ch = kbd.next().charAt(0);
		//determine if ch is digit, lowercase, or uppercase
		if (ch >= '0' && ch <= '9') {
			System.out.printf("%c is %s",ch, "digit");
	} else if (ch>= 'a' && ch <= 'z') {
			System.out.printf("%c is %s", ch, "lowercase");
		}else if (ch >= 'A' && ch <='Z') {
			System.out.printf("%c is %s",ch,"uppercase");
		}else {
			System.out.printf("%c is %s",ch,"another type");
		}
	
	
	}
}