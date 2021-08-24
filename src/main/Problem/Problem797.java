import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/25
 * @Content: 797. 所有可能的路径
 * 有向无环图，直接采用深度搜索遍历即可。
 */

public class Problem797 {

    static List<List<Integer>> ans = new ArrayList<>();
    static Deque<Integer> stack = new ArrayDeque<Integer>();

    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    private static void dfs(int[][] graph, int x, int n) {
        if (n == x) {
            ans.add(new ArrayList<Integer>(stack));
        }
        for (int g : graph[x]) {
            // 看到过两次了，dfs环绕一个push pop操作。
            stack.offerLast(g);
            dfs(graph, g, n);
            stack.pollLast();
        }
    }
}
