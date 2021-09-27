package Week3;

import edu.princeton.cs.algs4.*;

import java.util.HashMap;
import java.util.Map;

public class NewThreeSum {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        In in = new In(args[0]);
        int[] array = in.readAllInts();
        int result = 0;

        for (int i = 0; i < array.length; ++i) {
            map.put(array[i], i);
        }

        for (int i = 0; i < array.length - 2; ++i) {
            for (int j = i + 1; j < array.length - 1; ++j) {
                if (map.containsKey(-array[i] - array[j]) && map.get(-array[i] - array[j]) > j) {
                    ++result;
                }
            }
        }
        StdOut.println(result);
    }
}