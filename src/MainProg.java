import java.io.File;
import java.util.Scanner;

public class MainProg
{
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception
	{
		int option = 0;

		String pattern = inputPattern();
		String fileString = inputFile();
		
		while(option != 2)
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
		System.out.println("2. Quit");
	}

	public static String inputPattern()
	{
		System.out.printf("Enter search string:");
		String pattern = sc.nextLine();
		return pattern;
	}
	
	public static String inputFile() throws Exception
	{
		System.out.printf("Enter file name:");
		String fileString = "";
		File file = new File(sc.nextLine());
		Scanner fileSC = new Scanner(file);

		fileSC.nextLine();
		while(fileSC.hasNextLine())
		{
			fileString += fileSC.nextLine();
		}

		fileSC.close();
		return fileString;
	}
}