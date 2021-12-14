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
    public static boolean[][] ok = new boolean[15][15];
    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static boolean check(int x, int y, int m, int n) {
        return x >= 0 && y >=0 && x < m && y < n && !ok[x][y];
    }

    public static int dfs(int x, int y, int m, int n, List<List<Integer>> matrix) {
        int[][] h = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
        int ans = 1;
        
        ok[x][y] = true;
        for (int k = 0; k < 8; ++k) {
            int i = x + h[k][0];
            int j = y + h[k][1];
            if (check(i, j, m, n)) {
                if (matrix.get(i).get(j) == 1) {
                    ans += dfs(i, j, m, n, matrix);
                }
            }
        }
        return ans;
    }

    public static int connectedCell(List<List<Integer>> matrix) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int res = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                ok[i][j] = false;
            }
        }
        
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!ok[i][j] && matrix.get(i).get(j) == 1) {
                    res = Math.max(res, dfs(i, j, m, n, matrix));
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

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
