package Week2;

import edu.princeton.cs.algs4.*;

public class UFClient2 {
    public static void main(String[] args) {
        boolean check = false;
        In in = new In(args[0]);
        int[] array = in.readAllInts();
        int N = array[0];
        UF uf = new UF(N);

        for (int i = 1; i < array.length; i += 2) {
            int p = array[i], q = array[i + 1];
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                if (uf.count() < 2 && !check) {
                    check = true;
                    StdOut.println((i + 1) / 2);
                }
            }
        }

        if (!check) {
            StdOut.println("FAILED");
        }
    }
}