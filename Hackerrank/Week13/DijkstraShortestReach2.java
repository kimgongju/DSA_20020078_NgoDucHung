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
     * Complete the 'shortestReach' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY edges
     *  3. INTEGER s
     */
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static List<Integer> shortestReach(int n, List<List<Pair>> edges, int s) {
        List<Integer> ans = new ArrayList<>();
        
        for (int i = 1; i <= n; ++i) {
            ans.add(-1);
        }
        ans.set(s - 1, 0);
        pq.add(new Pair(0, s));
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            if (ans.get(temp.se - 1) != temp.fi) {
                continue;
            }
            for (Pair i : edges.get(temp.se)) {
                int x = i.fi;
                int w = i.se;
                
                if (ans.get(x - 1) < 0 || ans.get(x - 1) > temp.fi + w) {
                    ans.set(x - 1, temp.fi + w);
                    pq.add(new Pair(temp.fi + w, x));
                }
            }
        }
        
        return ans;
    }


}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public String next() {
        return readString();
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}
class Pair implements Comparable {
    int fi;
    int se;

    public Pair(int fi, int se) {
        this.fi = fi;
        this.se = se;
    }

    @Override
    public int compareTo(Object o) {
        Pair other = (Pair) o;
        
        if (fi != other.fi) {
            return fi - other.fi;
        }
        
        return se - other.se;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fi, se);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair other = (Pair) o;
        
        return fi == other.fi && se == other.se;
    }
}

public class B3 {
    public static void main(String[] args) throws IOException {
        InputReader input = new InputReader(System.in);
        List<List<Pair>> edges = new ArrayList<>();
        Map<Pair, Integer> map = new HashMap<>();
        int test = input.readInt();
        
        for (int i = 0; i < test; ++i) {
            int n = input.readInt();
            int m = input.readInt();
            
            edges.clear();
            for (int j = 0; j <= n; ++j) {
                edges.add(new ArrayList<>());
            }
            map.clear();
            for (int j = 0; j < m; ++j) {
                int x = input.readInt();
                int y = input.readInt();
                int w = input.readInt();
                Pair temp = new Pair(x, y);
                
                if (map.containsKey(temp)) {
                    map.put(temp, Math.min(map.get(temp), w));
                }
                else {
                    map.put(temp, w);
                }
            }
            for (Pair j : map.keySet()) {
                int x = j.fi;
                int y = j.se;
                int w = map.get(j);
                
                edges.get(x).add(new Pair(y, w));
                edges.get(y).add(new Pair(x, w));
            }
            int x = input.readInt();     
            List<Integer> ans = Result.shortestReach(n, edges, x);
            
            for (int j : ans) {
                if (j == 0) {
                    continue;
                }
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
