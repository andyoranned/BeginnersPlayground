package anneDavisProject2;


	/*
	 * Name:		 Anne Davis
	 * Student #: 	 w204233986
	 * Class: 		 COSC - 1436 - 22525
	 * Assignment:   Project 2
	 * Date:		 March 8, 2021
	 * 
	 */



	import java.io.File;
	import java.io.IOException;
	import java.util.Scanner;

	public class Project2 {
		public static void main(String[] args) throws IOException {		//main method; start of program
			
			
			
			File encryptFile = new File("data_plain_alphabet.txt");		//file object for scanner to reference
			Scanner encryptScan = new Scanner(encryptFile);				//create scanner object referencing the file
			
			
			//while loop to read and process 1 line per iteration from file
			while (encryptScan.hasNext())
			{
				
				String input = encryptScan.nextLine();			//read a line from the file
				String encryptedInput = encrypt(input);			//call encrypt method
				System.out.println(encryptedInput);				//print encrypted line to console
				
			} //concludes while loop reading file
			encryptScan.close();  								//closes file
			
			
			//print text to console to explain what's happening
			System.out.println("\nEncyption complete!\n");
			System.out.println("Initializing decryption sequence...\n");
			
			File decryptFile = new File("ciphertext.txt");			//file object for 2nd file
			Scanner decryptScan = new Scanner(decryptFile);			//scanner object referencing 2nd file
			
			//loop to read and process 2nd file
			while (decryptScan.hasNext()) {
				String inputDC = decryptScan.nextLine();			//read a line and assigns to string
				String decryptedInputDC = decrypt(inputDC);			//call decrypt method
				System.out.println(decryptedInputDC);				//prints decrypted line to console
			} //concludes decrypt while loop
			
			decryptScan.close();								//closes 2nd file
			
			
			System.out.println("\nDecryption complete!");
			
					
		} //concludes main method
		
		
		
		//method to encrypt text
		public static String encrypt (String text) {
			int shift = 4;										//variable for how far to shift chars
			String textHolder = "";								//string to hold encrypted chars
			
			//loop to encrypt string
			//one char for each itertion
			for (int i = 0; i < text.length(); i++) {
				char encryptedChar = text.charAt(i);		   //grabs a char from the string to process
				if (encryptedChar >= 'a' && encryptedChar <= 'z') {
					encryptedChar = Character.toUpperCase(encryptedChar);      //converts letter from lower to upper case
					encryptedChar += shift;					  //shifts to the right
					
					//Nested if statement wraps letters around alphabet
					if (encryptedChar > 'Z') {
						encryptedChar = (char)(encryptedChar - 26);
					} //concludes nested if statement
					
				} //concludes outer if statement
				
				textHolder += encryptedChar;				//adds shifted char to the string to hold	
			} //concludes the for loop
			
			return textHolder;								//sends encrypted string back to statement that called method
			
		}//concludes encrypt method 
		
		
		//method to decrypt text
			public static String decrypt (String textDC) {
				int shift = 3;										//variable for how far to shift chars
				String textHolderDC = "";							//string to hold decrypted chars
				
				//loop to decrypt string
				//one char for each itertion
				for (int i = 0; i < textDC.length(); i++) {
					char decryptedChar = textDC.charAt(i);		   //grabs a char from the string to process
					
					//if statement so that only alphabetical chars are processed
					if (decryptedChar >= 'A' && decryptedChar <= 'Z') {
						decryptedChar = Character.toLowerCase(decryptedChar);      //converts letter from upper to lower case
						decryptedChar -= shift;					  //shifts to the left
						
						//Nested if statement wraps letters around alphabet
						if (decryptedChar < 'a') {
							decryptedChar += 26;
						} //concludes nested if statement
						
					} //concludes outer if statement
					
					textHolderDC += decryptedChar;				//adds shifted char to the string to hold	
				} //concludes the for loop
				
				return textHolderDC;							//sends decrypted string back to statement that called method
				
			} //concludes decrypt method


	}


