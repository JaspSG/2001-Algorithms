import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// https://stackoverflow.com/questions/1770010/how-do-i-measure-time-elapsed-in-java
// based on the article and our understanding, we decided to use nanoTime to calculate elapsed time for more accurate
// analysis


public class MainProg
{
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception
	{
		int option = 0;

		String pattern = inputPattern();
		String fileString = inputFile();
		
		while(option != 5)
		{
			menu();
			System.out.printf("Option: ");
			option = sc.nextInt();
			switch(option)
			{
			case 1: 
				BruteForceAlgo.main(fileString, pattern);
				break;
			case 2:
				KMPAlgo.main(fileString, pattern);
				break;
			case 3:
				BoyerMooreAlgo.main(fileString, pattern);
				break;
			case 4:
				newalgo.main(fileString, pattern);
				break;
			case 5:
				break;
			default: 
				System.out.println("Invalid option!");
				break;
			}
		}
	}
	
	
	
	public static void menu()
	{
		System.out.println("Choose Algorithm");
		System.out.println("1. Brute Force");
		System.out.println("2. KMP");
		System.out.println("3. Boyer Moore");
		System.out.println("4. New Algorithm");
		System.out.println("5. Quit");
	}

	public static String inputPattern()
	{
		System.out.printf("Enter search string:");
		String pattern = sc.nextLine();
		return pattern;
	}
	
	public static String inputFile()
	{
		while(true)
		{
			try 
			{
				System.out.printf("Enter file name:");
				String fileString = "";
				File file = new File(sc.nextLine());
				Scanner fileSC;
				fileSC = new Scanner(file);
				fileSC.nextLine();
				while(fileSC.hasNextLine())
				{
					fileString += fileSC.nextLine();
				}
	
				fileSC.close();
				return fileString;
			} 
			catch (FileNotFoundException e) 
			{
				System.out.println("File not found!");
			}
		}		
	}
}