import java.io.File;
import java.util.Scanner;

public class MainProg
{
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception
	{
		int option = 0;

		char[] genomeArray = inputGenome();
		char[] fileArray = inputFile();
		
		while(option != 2)
		{
			menu();
			System.out.printf("Option: ");
			option = sc.nextInt();
			switch(option)
			{
			case 1: 
				BruteForceAlgo.main(fileArray, genomeArray);
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

	public static char[] inputGenome()
	{
		System.out.printf("Enter genome string:");
		String genome = sc.nextLine();
		char[] genomeArray = genome.toString().toCharArray();
		return genomeArray;
	}
	
	public static char[] inputFile() throws Exception
	{
		System.out.printf("Enter file name:");
		File file = new File(sc.nextLine());
		Scanner fileSC = new Scanner(file);
		StringBuilder fileContents = new StringBuilder();

		fileSC.nextLine();
		while(fileSC.hasNextLine())
		{
			fileContents.append(fileSC.nextLine());
		}
		char[] fileArray = fileContents.toString().toCharArray();

		fileSC.close();
		return fileArray;
	}
}