public class BoyerMooreAlgo 
{
	public static void main(String fileString, String pattern) 
	{
		String position = "";
		int total = 0;
		
		int badchar[] = new int[128]; 
		int shift = 0;
        
    	for (int i = 0; i < 128; i++)
    		badchar[i] = -1;
    	
    	for (int i = 0; i < pattern.length(); i++)
    		badchar[pattern.charAt(i)] = i;
		
		while(shift <= (fileString.length() - pattern.length()))
		{
			int j = pattern.length() - 1;

			while (j >= 0 && pattern.charAt(j) == fileString.charAt(shift + j))
				j--;
			
			if(j < 0)
			{
				position += shift + 1;
				position += " ";
				total++;

				if(shift + pattern.length() < fileString.length())
					shift = shift + (pattern.length() - badchar[fileString.charAt(shift + pattern.length())]);
				
				else
					shift++;
			}
			
			else if(1 > (j - badchar[fileString.charAt(shift + j)]))
					shift++;
			
			else
				shift = shift + (j - badchar[fileString.charAt(shift + j)]);
		}
		
		System.out.printf("Positions: %s\n", position);
		System.out.printf("Total: %d\n", total);
	}
}
