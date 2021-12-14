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
     * Complete the 'prims' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER start
     */
    
    public static class X implements Comparable<X> {
        public int x;
        public int w;
        
        public X(int x1, int w1) {
            x = x1;
            w = w1;
        }
        
        @Override
        public int compareTo(X c) {
            if (w < c.w) {
                return -1;
            }
            if (w > c.w) {
                return 1;
            }
            if (x < c.x) {
                return -1;
            }
            if (x > c.x) {
                return 1;
            }
            
            return 0;
        }
    }

    public static int prims(int n, List<List<Integer>> edges, int start) {
    // Write your code here
        PriorityQueue<X> pq = new PriorityQueue<X>();
        int res = 0;
        boolean[] ok = new boolean[3005];
        LinkedList<X> list[] = new LinkedList[3005];
        
        for (int i = 0; i <= n; ++i) {
            ok[i] = false;
            list[i] = new LinkedList<X>();
        }
        for (List<Integer> i : edges) {
            list[i.get(0)].addLast(new X(i.get(1), i.get(2)));
            list[i.get(1)].addLast(new X(i.get(0), i.get(2)));
        }
        pq.add(new X(start, 0));
        while(pq.size() > 0) {
            while (pq.size() > 0 && ok[pq.peek().x]) {
                pq.poll();
            }
            if (pq.size() < 1) {
                break;
            }
            X temp = pq.poll();
            
            ok[temp.x] = true;
            res += temp.w;
            for (X i : list[temp.x]) {
                pq.add(i);
            }
        }
        
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int start = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.prims(n, edges, start);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
