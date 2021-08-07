import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/6
 * @Content: 847
 */
public class UNsolveProblem847 {

    public static void main(String[] args) {
        int[][] graph = {{1},{0,2,4},{1,3,4},{2},{1,2}};
        System.out.println(shortestPathLength(graph));
    }

    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] seen = new boolean[n][1 << n];
        for (int i = 0; i < n; ++i) {
            queue.offer(new int[]{i, 1 << i, 0});
            seen[i][1 << i] = true;
        }

        for (boolean[] booleans : seen) {
            System.out.println(Arrays.toString(booleans));
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll();
            // mask 是一个二进制位的存储
            int u = tuple[0], mask = tuple[1], dist = tuple[2];
            // mask = 2^n-1
            if (mask == (1 << n) - 1) {
                ans = dist;
                break;
            }
            // 搜索相邻的节点
            for (int v : graph[u]) {
                // 将 mask 的第 v 位置为 1
                int maskV = mask | (1 << v);
                if (!seen[v][maskV]) {
                    queue.offer(new int[]{v, maskV, dist + 1});
                    seen[v][maskV] = true;
                }
            }
        }
        return ans;
    }

}
