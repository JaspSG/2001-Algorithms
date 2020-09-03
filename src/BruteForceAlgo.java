import java.util.Scanner;

public class BruteForceAlgo
{
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(char[] fileArray, char[] genomeArray)
	{
		String position = "";
		int total = 0;

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
	}
}