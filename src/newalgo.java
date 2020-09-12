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
        int jump = 3*(a-1);

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
        for(int i=0; i<startCodonArray.size(); i++)
        {
            // check if endCodon matches
            // initisalisation
            int fileIndex = 0; // start codon start index
            int fileIndex2 = 0; // end codon start index

            fileIndex = startCodonArray.get(i); // set fileindex to startindex of startcodon
            fileIndex2 = fileIndex + jump;  // set fileindex2 to startindex of endcodon

            for(int j=(0+jump); j<(0+jump+3); j++)
            {
                if(fileString.charAt(fileIndex2) == pattern.charAt(j))
                {
                    continue;
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
            }


        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Execution Time " + executionTime + "ns");
        System.out.printf("Positions: %s\n", position);
        System.out.printf("Total: %d\n", total);

    }


}