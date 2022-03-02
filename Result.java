import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    private static final DecimalFormat df = new DecimalFormat("0.000000");
    
    public static void plusMinus(List<Integer> arr) {
    // Write your code here
    
        Integer zeroInteger = new Integer(0);
        int total = arr.size();
        int  positiveNumberCount = 0; 
        int  negtiveNumberCount = 0; 
        int  zeroCount = 0; 
        
        for (Integer integer : arr) {
            if(integer.compareTo(zeroInteger) > 0)
                positiveNumberCount++;
            else if(integer.compareTo(zeroInteger) == 0)
                zeroCount++;
            else 
                negtiveNumberCount++;
        }
        
        double ratioPositiveNumber = (double)positiveNumberCount/total;
        double ratioNegtiveNumber = (double)negtiveNumberCount/total;
        double ratioZeroNumber = (double)zeroCount/total;
        
        // System.out.println(total);
        
        // System.out.println(positiveNumberCount);
        // System.out.println(negtiveNumberCount);
        // System.out.println(zeroCount);
        
        System.out.println(df.format(ratioPositiveNumber));
        System.out.println(df.format(ratioNegtiveNumber));
        System.out.println(df.format(ratioZeroNumber));
    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
