package Week2;

import edu.princeton.cs.algs4.*;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
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

        for (int value : array) {
            if (map.get(-value) != null && map.get(value) != null && map.get(-value) > 0 && map.get(value) > 0) {
                StdOut.println(value + " " + (-value));
                map.put(value, 0);
                map.put(-value, 0);
            }
        }
    }
}
