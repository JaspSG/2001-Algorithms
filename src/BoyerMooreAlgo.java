
public class BoyerMooreAlgo {

	public static void main(String fileString, String pattern) {
		// TODO Auto-generated method stub

		
		char[] fileArray = fileString.toString().toCharArray();
		char[] patternArray = pattern.toString().toCharArray();

		//BM start
		/* A pattern searching function that uses Bad 
		Character Heuristic of Boyer Moore Algorithm */
		int mPatLength = patternArray.length;
		int nFullTextLength = fileArray.length;
		
		int badchar[] = new int[nFullTextLength]; // <--- the whole fna char length are bad char
		
		//The preprocessing function for Boyer Moore's 
		//bad character heuristic
    	int i; 
        
    	// Initialize all occurrences as -1 
    	for (i = 0; i < nFullTextLength; i++) 
    	{
    		badchar[i] = -1; 
    	}
    	// Fill the actual value of last occurrence 
    	// of a character 
    	for (i = 0; i < mPatLength; i++)
    	{
    		badchar[(int) patternArray[i]] = i; 
    	}
    	// end of The preprocessing function for Boyer Moore's
		//badCharHeuristic(patternArray, mPatLength, badchar, nFullText);
		
		int shift = 0;// shift of the pattern with 
						// respect to text
		
		while(shift <= (nFullTextLength - mPatLength))
		{
			int j = mPatLength - 1;
			
	   		/* Keep reducing index j of pattern while 
			characters of pattern and text are 
			matching at this shift */
			while (j >= 0 && patternArray[j] == fileArray[shift + j])
			{
				j--;
			}
			
		
			/* If the pattern is present at current 
			shift, then index j will become -1 after 
			the above loop */
			if(j < 0)
			{
				// shift position count start at 0. Thus +1 show that the position start at 1
				System.out.println("Patterns occur at shift = " + (shift+1)); 
	
				/* original code
				 * System.out.println("Patterns occur at shift = " + s);
				 */
				
				/* Shift the pattern so that the next 
					character in text aligns with the last 
					occurrence of it in pattern. 
					The condition (shift +mPatLength < nFullTextLength is necessary for 
					the case when pattern occurs at the end 
					of text */
				if(shift + mPatLength < nFullTextLength)
				{
					shift = shift + (mPatLength - badchar[fileArray[shift + mPatLength]]);
				}
				else
				{
					shift = shift + 1;
				}
				
				
			}
			else 
			{
				/* Shift the pattern so that the bad character 
				in text aligns with the last occurrence of 
				it in pattern. The max function is used to 
				make sure that we get a positive shift. 
				We may get a negative shift if the last 
				occurrence of bad character in pattern 
				is on the right side of the current 
				character. */
				//A utility function to get maximum of two integers
				if(1 > (j - badchar[fileArray[shift + j]]))
				{
					shift = shift + 1;
				}
				else
				{
					shift = shift + (j - badchar[fileArray[shift + j]]);
				}
			}
			
		}
		
		
	}

}
