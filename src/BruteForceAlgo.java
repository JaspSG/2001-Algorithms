import java.util.Scanner;

public class BruteForceAlgo
{
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String fileString, String pattern)
	{
		String position = "";
		int total = 0;

		for(int i = 0; i < (fileString.length() - pattern.length()); i++)
		{
			if(fileString.charAt(i) == pattern.charAt(0))
			{
				for(int j = 1; j < pattern.length(); j++)
				{
					if(!(fileString.charAt(i + j) == pattern.charAt(j)))
					{
						break;
					}
					
					else if(j == pattern.length()-1)
					{
						position += i+1;
						position += " ";
						total++;
					}
				}
			}
		}
		if(position.equals(""))
			System.out.println("No occurrence!");
		else
		{
			System.out.printf("Positions: %s\n", position);
			System.out.printf("Total: %d\n", total);
		}
	}
}