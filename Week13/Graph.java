package Week13;

import java.util.LinkedList;

public class Graph {
    public int n;
    public int m;
    public int maxx;

    public static class edges {
        public int x;
        public int w;

        public edges(int x1, int w1) {
            x = x1;
            w = w1;
        }
    }

    LinkedList<edges> list[] = new LinkedList[10000];

    public void addEdge(int v1, int v2, int weight) {
        list[v1].addLast(new edges(v2, weight));
        list[v2].addLast(new edges(v1, weight));
        ++m;
    }

    public void removeEdge(int v1, int v2) {
        list[v1].removeIf((edges u) -> {
            boolean ok = u.x == v2;

            if (ok) {
                --m;
            }

            return ok;
        });
        list[v2].removeIf(u -> u.x == v1);
    }

    public void addVertice(int v) {
        list[v] = new LinkedList<edges>();
        maxx = Math.max(v, maxx);
        ++n;
    }

    public void removeVertice(int v) {
        for (int i = 0; i < list[v].size(); ++i) {
            int u = list[v].get(i).x;

            list[u].removeIf(k -> k.x == v);
        }
        list[v].clear();
        if (maxx == v) {
            for (int i = maxx - 1; i > 0; --i) {
                if (!list[i].isEmpty()) {
                    maxx = i;
                    break;
                }
            }
        }
        --n;
    }

    public boolean hasConnect(int v1, int v2) {
        for (int i = 0; i < list[v1].size(); ++i) {
            int u = list[v1].get(i).x;

            if (u == v2) {
                return true;
            }
        }

        return false;
    }

    public int[] getAdjacencyVertices(int v) {
        int[] ans = new int[list[v].size()];

        for (int i = 0; i < list[v].size(); ++i) {
            ans[i] = list[v].get(i).x;
        }

        return ans;
    }

    public void dfs(int start) {
        boolean[] ok = new boolean[maxx + 1];

        for (int i = 1; i <= maxx; ++i) {
            ok[i] = false;
        }
        runDFS(start, ok);
    }

    public void runDFS(int v, boolean[] ok) {
        ok[v] = true;
        for (int i = 0; i < list[v].size(); ++i) {
            int u = list[v].get(i).x;

            if (!ok[u]) {
                runDFS(u, ok);
            }
        }
    }

    public void bfs(int start) {
        boolean[] ok = new boolean[maxx + 1];
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= maxx; ++i) {
            ok[i] = false;
        }
        runBFS(start, ok, queue);
    }

    public void runBFS(int x, boolean[] ok, LinkedList<Integer> queue) {
        ok[x] = true;
        queue.add(x);
        while(!queue.isEmpty()) {
            int top = queue.poll();

            for (int i = 0; i < list[top].size(); ++i) {
                int u = list[top].get(i).x;

                if (!ok[u]) {
                    ok[u] = true;
                    queue.add(u);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
