import java.util.*;

// 743. 网络延迟时间
public class Problem743 {

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        System.out.println(networkDelayTime1(times, n, k));
    }

    // BFS
    public static int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }
        int[] r = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            r[i] = Integer.MAX_VALUE;
        }
        r[k] = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{k, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (map.containsKey(cur[0])) {
                for (Integer key : map.get(cur[0]).keySet()) {
                    int t = map.get(cur[0]).get(key) + cur[1];
                    if (t < r[key]) {
                        r[key] = t;
                        queue.add(new int[]{key, t});
                    }
                }
            }
        }
        Arrays.sort(r);
        return r[n] == Integer.MAX_VALUE ? -1 : r[n];
    }

    // Dijkstra
    public static int networkDelayTime1(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], INF);
        }
        for (int[] t : times) {
            int x = t[0] - 1, y = t[1] - 1;
            g[x][y] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int x = -1;
            for (int y = 0; y < n; ++y) {
                if (!used[y] && (x == -1 || dist[y] < dist[x])) {
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; ++y) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
            System.out.println(Arrays.toString(used));
            System.out.println(Arrays.toString(dist));
        }

        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == INF ? -1 : ans;
    }

}
