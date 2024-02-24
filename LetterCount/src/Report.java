import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Report
{
	int[][] array1= { {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
					{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0} };
	String str = "";							//receives lines from file read in getArray method
	String str2= "";							//used in generateReport
	char ch = ' ';								//hold char for CharAt during file read in getArray
	char ch2 = ' ';								//used to hold letter in generateReport
	
	/*generateReport method is used to produce
	 * the final formated report, display it
	 * on the console and save it to a text 
	 * file 
	 */
	public void generateReport(int[][] array1) throws IOException
	{

		//open file to save to
		PrintWriter outputFile= new PrintWriter("output.txt");
		
		//Report's header
		String header1="        .________________________________,\n";
		String header2="\t|    Frequency of Each Letter   ||\n";
		String header3="        L===============================##\n";
		String header4="Letter\t|\tUpper Case\t|\tLower Case\n";
		String header5="--------------------------------------------------------\n";
		System.out.print(header1);
		outputFile.print(header1);
		System.out.print(header2);
		outputFile.print(header2);
		System.out.print(header3);
		outputFile.print(header3);
		System.out.print(header4);	
		outputFile.print(header4);
		System.out.print(header5);
		outputFile.print(header5);
		
		//loop to populate report + save to output file
		for (int inc=0; inc<array1[0].length; inc++)
		{
			ch2=(char)(inc+65);
			System.out.print(ch2+"\t");
			outputFile.print(ch2);
			String str2=String.format("%15d\t\t%15d\n", array1[0][inc], array1[1][inc]);
			System.out.print(str2);
			outputFile.print(str2);
		}//end for loop
		outputFile.close();
		System.out.print("A copy of this report was saved as \"output.txt.\"");		
	}//end of generateReport
	
	/* getArray method is used to read file 
	 * and analyze data to determine the
	 * frequency of keystrokes and save that
	 * information to a 2d array
	 */
	public int[][] getArray(String userFile) throws IOException
	{
		File file=new File(userFile);
		Scanner inputFile=new Scanner(file);
		
		//read file
		while (inputFile.hasNext())
		{
			//reads the next line and stores in String
			str= inputFile.nextLine();
			for (int i=0; i<str.length(); i++)
			{
				ch = str.charAt(i);
				switch (ch)						//accumulates the frequency of each character
				{								//in corresponding element in freq array
				case 'A':
					array1[0][0] += 1;
					break;
				case 'B':
					array1[0][1] += 1;
					break;
				case 'C':
					array1[0][2] += 1;
					break;
				case 'D':
					array1[0][3] += 1;
					break;
				case 'E':
					array1[0][4] += 1;
					break;
				case 'F':
					array1[0][5] += 1;
					break;
				case 'G':
					array1[0][6] += 1;
					break;
				case 'H':
					array1[0][7] += 1;
					break;
				case 'I':
					array1[0][8] += 1;
					break;
				case 'J':
					array1[0][9] += 1;
					break;
				case 'K':
					array1[0][10] += 1;
					break;
				case 'L':
					array1[0][11] += 1;
					break;
				case 'M':
					array1[0][12] += 1;
					break;
				case 'N':
					array1[0][13] += 1;
					break;
				case 'O':
					array1[0][14] += 1;
					break;
				case 'P':
					array1[0][15] += 1;
					break;
				case 'Q':
					array1[0][16] += 1;
					break;
				case 'R':
					array1[0][17] += 1;
					break;
				case 'S':
					array1[0][18] += 1;
					break;
				case 'T':
					array1[0][19] += 1;
					break;
				case 'U':
					array1[0][20] += 1;
					break;
				case 'V':
					array1[0][21] += 1;
					break;
				case 'W':
					array1[0][22] += 1;
					break;
				case 'X':
					array1[0][23] += 1;
					break;
				case 'Y':
					array1[0][24] += 1;
					break;
				case 'Z':
					array1[0][25] += 1;
					break;
				case 'a':					//lower case test conditions starts here
					array1[1][0] += 1;
					break;
				case 'b':
					array1[1][1] += 1;
					break;
				case 'c':
					array1[1][2] += 1;
					break;
				case 'd':
					array1[1][3] += 1;
					break;
				case 'e':
					array1[1][4] += 1;
					break;
				case 'f':
					array1[1][5] += 1;
					break;
				case 'g':
					array1[1][6] += 1;
					break;
				case 'h':
					array1[1][7] += 1;
					break;
				case 'i':
					array1[1][8] += 1;
					break;
				case 'j':
					array1[1][9] += 1;
					break;
				case 'k':
					array1[1][10] += 1;
					break;
				case 'l':
					array1[1][11] += 1;
					break;
				case 'm':
					array1[1][12] += 1;
					break;
				case 'n':
					array1[1][13] += 1;
					break;
				case 'o':
					array1[1][14] += 1;
					break;
				case 'p':
					array1[1][15] += 1;
					break;
				case 'q':
					array1[1][16] += 1;
					break;
				case 'r':
					array1[1][17] += 1;
					break;
				case 's':
					array1[1][18] += 1;
					break;
				case 't':
					array1[1][19] += 1;
					break;
				case 'u':
					array1[1][20] += 1;
					break;
				case 'v':
					array1[1][21] += 1;
					break;
				case 'w':
					array1[1][22] += 1;
					break;
				case 'x':
					array1[1][23] += 1;
					break;
				case 'y':
					array1[1][24] += 1;
					break;
				case 'z':
					array1[1][25] += 1;
					break;
				default:
					break;
				}//end of switch statement
			}//end for loop		
		}//end of reading file/while loop
		inputFile.close();
		return array1;
	}//end getArray	
}//end report class