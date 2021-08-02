import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        Integer max = Integer.MAX_VALUE;
        int[][] graph = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int n = 4;
        int source = 2;
        dijkstraAll(graph, n, source);
    }

    /**
     * dijkstra算法
     * 这里需要全连通，否则会造成死循环
     * @param graph  有向边图
     * @param n      节点数
     * @param source 源节点
     */
    private static void dijkstra(int[][] graph, int n, int source) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        // 把有向图的信息存入map中便于操作
        // 这里给出的下标是从1开始，改为从0
        for (int[] edge : graph) {
            map.putIfAbsent(edge[0] - 1, new HashMap<>());
            map.get(edge[0] - 1).put(edge[1] - 1, edge[2]);
        }
        System.out.println("map"+map);
        // 最短路径数组
        int[] dist = new int[n];
        // 前驱结点数组
        int[] prev = new int[n];
        //Queue存储操作节点
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
            set.add(i);
        }

        dist[source - 1] = 0;

        while (!set.isEmpty()) {
            int u = -1;
            int minDist = Integer.MAX_VALUE;
            for (Integer s : set) {
                if (dist[s] < minDist) {
                    minDist = dist[s];
                    u = s;
                }
            }
            System.out.println("remove"+u);
            set.remove(u);
            if (map.containsKey(u)) {
                for (Integer key : map.get(u).keySet()) {
                    System.out.println(u+" "+key);
                    int alt = map.get(u).get(key) + dist[u];
                    if (alt < dist[key]) {
                        dist[key] = alt;
                        prev[key] = u;
                    }
                }
            }
        }
        System.out.println("dist:" + Arrays.toString(dist));
        System.out.println("prev:" + Arrays.toString(prev));
    }

    /**
     * dijkstra算法
     * @param graph  有向边图
     * @param n      节点数
     * @param source 源节点
     */
    private static void dijkstraAll(int[][] graph, int n, int source) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        // 把有向图的信息存入map中便于操作
        // 这里给出的下标是从1开始，改为从0
        for (int[] edge : graph) {
            map.putIfAbsent(edge[0] - 1, new HashMap<>());
            map.get(edge[0] - 1).put(edge[1] - 1, edge[2]);
        }
        // 最短路径数组
        int[] dist = new int[n];
        // 前驱结点数组
        int[] prev = new int[n];
        //Queue存储操作节点
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            prev[i] = -1;
        }

        dist[source - 1] = 0;
        queue.add(source-1);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (map.containsKey(u)) {
                // 将与当前点指向的所有点都加入queue中
                for (Integer key : map.get(u).keySet()) {
                    int alt = map.get(u).get(key) + dist[u];
                    if (alt < dist[key]) {
                        dist[key] = alt;
                        prev[key] = u;
                        queue.add(key);
                    }
                }
            }
        }
        // 若存在Integer.MAX_VALUE证明此点是不能联通的
        System.out.println("dist:" + Arrays.toString(dist));
        System.out.println("prev:" + Arrays.toString(prev));
    }
}
