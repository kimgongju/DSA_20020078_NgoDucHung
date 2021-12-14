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
     * Complete the 'insertionSort1' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort1(int n, List<Integer> arr) {
        int[] array = new int[arr.size()];
        
        for (int i = 0; i < array.length; ++i) {
            array[i] = arr.get(i);
        }
        for (int i = array.length - 1; i > 0; --i) {
            int temp = array[i];

            if (temp < array[i - 1]) {
                array[i] = array[i - 1];
                for (int j : array) {
                    System.out.print(j + " ");
                }
                System.out.println();
                array[i - 1] = temp;
            }
        }
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
