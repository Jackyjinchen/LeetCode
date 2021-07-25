import java.util.*;

// 1743. 从相邻元素对还原数组
public class Problem1743 {
    public int solutionNum = 1;


    public int[] solution1(int[][] adjacentPairs) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            map.putIfAbsent(adjacentPair[0], new ArrayList<Integer>());
            map.putIfAbsent(adjacentPair[1], new ArrayList<Integer>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);

        }

        int n = adjacentPairs.length + 1;
        int[] res = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int e = entry.getKey();
            List<Integer> value = entry.getValue();
            if (value.size() == 1) {
                res[0] = e;
                break;
            }
        }
        res[1] = map.get(res[0]).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> adj = map.get(res[i - 1]);
            res[i] = res[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] adjacentPairs = {{2, 1}, {3, 4}, {3, 2}};
        Problem1743 problem1743 = new Problem1743();
        System.out.println(problem1743.solution1(adjacentPairs));
    }
}