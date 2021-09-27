package Week2;

import edu.princeton.cs.algs4.*;

import java.util.HashMap;
import java.util.Map;

public class ThreeSum {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        In in = new In(args[0]);
        int[] array = in.readAllInts();

        for (int value : array) {
            if (map.containsKey(value)) {
                map.put(value, 1 + map.get(value));
            } else {
                map.put(value, 1);
            }
        }

        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = i + 1; j < array.length; ++j) {
                if (map.get(-array[i] - array[j]) != null && map.get(-array[i] - array[j]) > 0) {
                    StdOut.println(array[i] + " " + array[j] + " " + (-array[i] - array[j]));
                }
            }
        }
    }
}