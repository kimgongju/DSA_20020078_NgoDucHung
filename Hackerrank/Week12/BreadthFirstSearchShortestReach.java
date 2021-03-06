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
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        boolean[] ok = new boolean[n];
        int[] dis = new int[n];
        LinkedList<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        ArrayList<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>();
        
        for(int i = 0; i < n; ++i) {
            graph.add(new HashSet<Integer>());
        }
        for (int i = 0; i < m; ++i) {
            int x = edges.get(i).get(0) - 1;
            int y = edges.get(i).get(1) - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        queue.add(s - 1);
        for (int i = 0; i < n; ++i) {
            ok[i] = false;
            dis[i] = -1;
        }
        dis[s - 1] = 0;
        ok[s - 1] = true;
        while(!queue.isEmpty()) {
            int x = queue.remove();
            
            for (int y : graph.get(x)) {
                if (!ok[y]) {
                    queue.add(y);
                    ok[y] = true;
                    dis[y] = dis[x] + 6;
                }
            }
        }
        for (int i : dis) {
            if (i != 0) {
                res.add(i);
            }
        }
        
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
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

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
