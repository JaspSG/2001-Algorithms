import java.io.File;
import java.util.Scanner;

public class BruteForceAlgo
{
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception
	{
		String position = "";
		int total = 0;
		
		String genome = inputGenome();
		String fileName = inputFile();
		
		StringBuilder fileContents = new StringBuilder();
		File file = new File(fileName);
		Scanner fileSC = new Scanner(file);
		
		fileSC.nextLine();
		while(fileSC.hasNextLine())
		{
			fileContents.append(fileSC.nextLine());
		}
		char[] fileArray = fileContents.toString().toCharArray();
		char[] genomeArray = genome.toString().toCharArray();

		for(int i = 0; i < fileArray.length; i++)
		{
			if(fileArray[i] == genomeArray[0])
			{
				for(int j = 1; j < genomeArray.length; j++)
				{
					if(!(fileArray[i+j] == genomeArray[j]))
					{
						break;
					}
					if(j == genomeArray.length-1)
					{
						position += i+1;
						position += " ";
						total++;
					}
				}
			}
		}
		if(position.equals(""))
			System.out.println("Not found!");
		else
		{
			System.out.printf("Positions: %s\n", position);
			System.out.printf("Total: %d\n", total);
		}
		
		fileSC.close();
	}

	public static String inputGenome()
	{
		System.out.printf("Enter genome string:");
		String genome = sc.nextLine();
		return genome;
	}
	
	public static String inputFile()
	{
		System.out.printf("Enter file name:");
		String file = sc.nextLine();
		return file;
	}
}