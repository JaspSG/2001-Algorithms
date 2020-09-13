public class KMPAlgo
{
	public static void main(String fileString, String pattern)
	{
		long startTime = System.nanoTime(); // start time

		String position = "";
		int total = 0;

		int lps[] = new int[pattern.length()];
		LPSArray(pattern, lps);
		int j = 0;

		for(int i = 0; i < fileString.length(); i++)
		{
			if(fileString.charAt(i) == pattern.charAt(j))
				j++;
			
			else if(j != 0)
			{
				j = lps[j - 1];
				i--;
			}

			if(j == pattern.length())
			{
				position += i - j + 2;
				position += " ";
				total++;
				j = lps[j - 1];
			}
		}
		long endTime = System.nanoTime();
		long executionTime = endTime - startTime;
		System.out.println("Execution Time " + executionTime + "ns");
		if(position.equals(""))
			System.out.println("No occurrence!");
		else
		{
			System.out.printf("Positions: %s\n", position);
			System.out.printf("Total: %d\n", total);
		}
	}

	public static void LPSArray(String pattern, int lps[])
	{
		int j = 0;
		lps[0] = 0;

		for(int i = 1; i < pattern.length(); i++)
		{
			if(pattern.charAt(j) == pattern.charAt(i))
			{
				lps[i] = j + 1;
				j++;
			}
			
			else if(j != 0)
			{
				j = lps[j - 1];
				i--;
			}
			
			else
				lps[i] = 0;
		}
	}
}