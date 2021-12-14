import java.io.*;
import java.util.*;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; ++i) {
            array[i] = in.nextInt();
        }
        
        Arrays.sort(array);
        for (int i = 0; i < n; ++i) {
            System.out.print(array[i] + " ");
        }
    }
}
