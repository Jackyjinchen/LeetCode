import java.util.*;

// 743. 网络延迟时间
public class Problem743 {

    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4, k = 2;
        System.out.println(networkDelayTime(times, n, k));
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

}
