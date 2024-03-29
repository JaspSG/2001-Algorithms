// nucleotides / proteins come in a pair of 3 (based on biology)
// each nucleotides sequence will have a start and stop codon (based on biology)
// thus this algorithm will make use of the above knowledge and optimise the algorithm

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class newalgo{

    public static void main(String fileString, String pattern)
    {
        long startTime = System.nanoTime(); // start time

        // extract startCodon and endCodon
        String startCodon = pattern.substring(0,3);

        // formula to find end index:
        // patternlength mod 3 = a
        // startIndex + 3(a-1) = endCondon-startIndex
        int patternLength = pattern.length();
        int a = patternLength / 3;

        int jump = 3*(a-1); // mathematical formula to derive the jump from start index start codon to start index of stop codon

        String endCodon = pattern.substring(0+jump, jump+3);

        // store all occurence
        ArrayList<Integer> startCodonArray = new ArrayList<Integer>();

        //
        String position = " ";
        int total = 0;
        int index = 0; // initialise to 0 to start

        // Find all start index of start codon
        // create index-array table
        while(index<fileString.length())
        {
            int startindex = 0;
            startindex  =  fileString.indexOf(startCodon, index); //
            if(startindex != -1) {
                startCodonArray.add(startindex);
                index = startindex + 1; // jump to next index
            }
            else // when startindex == -1
            {
                break;
            }
        }
        // Compare all the start codon
        for(int i=0; i<startCodonArray.size(); i++) // O(m/n) + O(3) + O(n-6) + O(n)
        {
            // check if endCodon matches
            // initisalisation
            int fileIndex = 0; // start codon start index
            int fileIndex2 = 0; // end codon start index

            fileIndex = startCodonArray.get(i); // set fileindex to startindex of startcodon
            fileIndex2 = fileIndex + jump;  // set fileindex2 to startindex of endcodon
            int fileIndex3 = startCodonArray.get(i) + jump;

            for(int j=(0+jump); j<(0+jump+3); j++)
            {
                if(fileString.charAt(fileIndex3) != pattern.charAt(j))
                {
                    break;
                }
                else if(j == patternLength -1) // due to index
                {

                    // extract substring and bruteforce check the remaining string
                    // String comparisonString = fileString.substring(fileIndex, fileIndex2+3);

                    // startindex = fileIndex + 3
                    // endindex = fileIndex2 - 1
                    String comparisonString = fileString.substring(fileIndex+3, fileIndex2);


                    int subpatternstart = 3; //patternstart
                    int textpatternstart = fileIndex+3;

                    int subpatternend = jump-1;

                    if(comparisonString.length() == 0)
                    {
                        position += fileIndex + 1;
                        position += " ";
                        total ++;
                    }

                    for(int k = 0; k<comparisonString.length(); k++)
                    {
                        if(fileString.charAt(textpatternstart) != pattern.charAt(subpatternstart))
                        {
                            break;
                        }
                        else if(fileString.charAt(k) == pattern.charAt(subpatternstart))
                        {
                            subpatternstart++;
                            textpatternstart++;
                        }
                        else if(k == comparisonString.length()-1)
                        {
                            position += fileIndex + 1;
                            position += " ";
                            total ++;
                        }
                    }
                }
                else if(fileString.charAt(fileIndex3) == pattern.charAt(j))
                {
                    fileIndex3++;
                    continue;
                }
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
}