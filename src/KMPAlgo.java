import java.io.File;
import java.util.Scanner;

public class KMPAlgo
{
	public static void main(String fileString, String pattern)
	{
		int lengthText = fileString.length(); // compute the length of the text 
		int lengthPattern = pattern.length(); // compute the length of the pattern 
		int lps[] = new int[lengthPattern]; // create lps array table == length of the pattern 
		
		calculateLPS(pattern, lengthPattern, lps); // calculate the LongestPrefixSuffix Table 
		
		int i = 0; // variable to store index for text 
		int j = 0; // variable to store index for pattern 
		
		int total = 0; // variable to store total occurences 
		
		while(i<lengthText) // run while loop till end of text 
		{
			if(fileString.charAt(i) == pattern.charAt(j)) // if both character matches 
			{
				// check next occurences
				i++; // increment i index
				j++; // increment j index 
			}
			else // if character doesnt match 
			{
				if(j!=0)
				{
					j = lps[j-1]; // check lps table based on previous match 
				}
				else
				{
					i++; // increment i index 
				}
			}
			if(j==lengthPattern) // all pattern found 
			{
				System.out.printf("Positions: %s\n", i-j+1); // position = index + 1
				total++; // increment total variable 
				j = lps[j-1]; // reset match 
			}
			
		}
		System.out.printf("Total: %d\n", total); // print total occurences 
		
	}
	// calculate longest prefix suffix table 
	public static void calculateLPS(String pattern, int lengthPattern, int lps[])
	{
		// initialise variable 
		int length = 0;
		int i = 1;
		lps[0] = 0;
		
		while(i<lengthPattern)
		{
			if(pattern.charAt(length) == pattern.charAt(i)) 
			{
				lps[i] = length+1;
				length++;
				i++; 
			}
			else
			{
				if(length!= 0)
				{
					length = lps[length-1];
				}
				else
				{
					lps[i] = 0;
					i++;
				}
			}
		}
	}
}