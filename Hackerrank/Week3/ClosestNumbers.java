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
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void sort(int array[], int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int array[], int left, int mid, int right) {
        int length1 = mid - left + 1;
        int length2 = right - mid;
        int count = left;
        int count1 = 0;
        int count2 = 0;
        int l[] = new int[length1];
        int r[] = new int[length2];

        for (int i = 0; i < length1; ++i) {
            l[i] = array[left + i];
        }
        for (int i = 0; i < length2; ++i) {
            r[i] = array[mid + 1 + i];
        }
        while (count1 < length1 && count2 < length2) {
            if (l[count1] < r[count2]) {
                array[count++] = l[count1++];
            } else {
                array[count++] = r[count2++];
            }
        }
        while(count1 < length1) {
            array[count++] = l[count1++];
        }
        while(count2 < length2) {
            array[count++] = r[count2++];
        }
    }
    public static List<Integer> closestNumbers(List<Integer> arr) {
    // Write your code here
        int minn = 100000000;
        List<Integer> array = new ArrayList<Integer>();
        int[] a = new int[arr.size()];
        
        for (int i = 0; i < arr.size(); ++i) {
            a[i] = arr.get(i);
        }
        sort(a, 0, arr.size() - 1);
        for (int i = 0; i < arr.size(); ++i) {
            arr.set(i, a[i]);
        } 
        for (int i = 1; i < arr.size(); ++i) {
            minn = Math.min(minn, arr.get(i) - arr.get(i - 1));
        }
        for (int i = 1; i < arr.size(); ++i) {
            if (arr.get(i) - arr.get(i - 1) == minn) {
                array.add(arr.get(i - 1));
                array.add(arr.get(i));
            }
        }
        
        return array;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
