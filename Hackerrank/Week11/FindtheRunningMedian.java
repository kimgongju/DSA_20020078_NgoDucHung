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
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static class Pair implements Comparable {
        int fi, se;

        public Pair(int fi1, int se1) {
            fi = fi1;
            se = se1;
        }

        public int compareTo(Object o) {
            if (fi != ((Pair) o).fi) {
                return fi - ((Pair) o).fi;
            }
            return se - ((Pair) o).se;
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> res = new ArrayList<>();
        TreeSet<Pair> tree = new TreeSet<>();
        Pair median_left = new Pair(-1, -1);
        
        for(int i = 0; i < a.size(); ++i) {
            int v = a.get(i);
            Pair tmp = new Pair(v, i);
            
            tree.add(tmp);
            if (median_left.fi == -1) {
                median_left = new Pair(v, i);
                res.add(1.0 * v);
            } else {
                if (v < median_left.fi) {
                    if (i % 2 == 1) {
                        median_left = tree.lower(median_left);
                    }
                } else {
                    if (i % 2 == 0) {
                        median_left = tree.higher(median_left);
                    }
                }
                if (i % 2 == 0) {
                    res.add(median_left.fi * 1.0);
                }
                else {
                    res.add((median_left.fi + tree.higher(median_left).fi) / 2.0);
                }
            }
        }
        return res;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
