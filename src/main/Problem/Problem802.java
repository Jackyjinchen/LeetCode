import java.util.*;

// 802. 找到最终的安全状态
public class Problem802 {

    public static void main(String[] args) {
        // graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(graph));
    }

    // 建立一个反向图
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> list = new ArrayList<>();
        int[] inDeg = new int[n];
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        // 建立一个反向图
        for (int i = 0; i < n; i++) {
            for (int pos : graph[i]) {
                list.get(pos).add(i);
            }
            inDeg[i] = graph[i].length;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(inDeg[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int y = queue.poll();
            for (int x : list.get(y)) {
                if(--inDeg[x] == 0){
                    queue.offer(x);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(inDeg[i]==0) res.add(i);
        }

        return res;
    }

    //DFS
    public static List<Integer> eventualSafeNodes2(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (safe(graph, color, i)) {
                res.add(i);
            }
        }
        return res;
    }

    // 0未被访问 1递归栈或环上 2搜索完毕，安全节点
    public static boolean safe(int[][] graph, int[] color, int x) {
        if (color[x] > 0) return color[x] == 2;
        color[x] = 1;
        for (int y : graph[x]) {
            System.out.println(x + " " + y);
            if (!safe(graph, color, y)) {
                return false;
            }
        }
        color[x] = 2;
        return true;
    }

    public static List<Integer> eventualSafeNodesMyself1(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length != 0) {
                Set<Integer> temp = new HashSet<>();
                for (int point : graph[i]) {
                    temp.add(point);
                }
                if (temp.size() != 0) map.put(i, temp);
            } else if (!res.contains(i)) {
                res.add(i);
            }
        }
        boolean unchanged;
        do {
            unchanged = true;
            Set keys = map.keySet();
            if (keys != null) {
                Iterator iterator = keys.iterator();
                while (iterator.hasNext()) {
                    Object key = iterator.next();
                    Set<Integer> set = map.get(key);
                    if (set.size() == 0) {
                        iterator.remove();
                        res.add((Integer) key);
                        unchanged = false;
                    } else {
                        Iterator iterator1 = set.iterator();
                        while (iterator1.hasNext()) {
                            Object val = iterator1.next();
                            if (res.contains(val)) {
                                iterator1.remove();
                                unchanged = false;
                            }
                        }
                    }
                }
            }
        } while (!unchanged);
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return res;
    }
}
