import java.util.*;

// 218. 天际线问题
public class Problem218 {
    public int solutionNum = 1;
//        public int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
    public int[][] buildings = {{0, 2, 3}, {2, 5, 3}};
//    public int[][] buildings = {{0,2147483647,2147483647}};

    public List<List<Integer>> solution1(int[][] buildings) {
        // 维护一个优先队列来记住当前的最大高度和未结束的建筑信息
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        List<Integer> boundaries = new ArrayList<Integer>();
        for (int[] building : buildings) {
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        // 去除所有边界条件并将其排序
        Collections.sort(boundaries);

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int idx = 0, n = buildings.length;
        for (Integer boundary : boundaries) {
            // 保存 [结束点，高度] 信息在优先队列中
            while (idx < n && buildings[idx][0] <= boundary) {
                priorityQueue.add(new int[]{buildings[idx][1], buildings[idx][2]});
                idx++;
            }
            for (int[] ints : priorityQueue) {
                System.out.println(idx + " " + ints[0] + " " + ints[1]);
            }

        }


        return res;
    }

    public List<List<Integer>> solution2(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        // 维护一个优先队列来记住当前的最大高度和未结束的建筑信息
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) -> b[2] - a[2]);
        // boundaries记录边界条件 [边界值，建筑序号]
        PriorityQueue<int[]> boundaries = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < buildings.length; i++) {
            boundaries.offer(new int[]{buildings[i][0], i});
            boundaries.offer(new int[]{buildings[i][1], i});
        }
        // 记录当前的最大高度
        int maxheight = 0;
        // 当while循环的时候，需要去除掉他才行
        int len = buildings.length * 2;
        // 去除所有边界条件并将其排序
        for (int i = 0; i < len; i++) {
            // 取出下一个边界
            int idx = boundaries.peek()[0];

            // 记录一下是否重复了
            int tempLen = 0;

            // 这里要把端点重复的全部取出来
            while (!boundaries.isEmpty() && boundaries.peek()[0] == idx) {
                tempLen++;
                int[] pollItem = boundaries.poll();
                // 对于每一个边界条件，要判断他是否在优先队列里，即是结束还是开始
                // 结尾的处理
                if (priorityQueue.contains(buildings[pollItem[1]])) {
                    priorityQueue.remove(buildings[pollItem[1]]);
                }
                //进入队列的处理
                else {
                    priorityQueue.offer(buildings[pollItem[1]]);

                }
            }
            len = len - tempLen + 1;

            if (!priorityQueue.isEmpty()) {
                if (maxheight == priorityQueue.peek()[2]) {
                } else {
                    maxheight = priorityQueue.peek()[2];
                    res.add(Arrays.asList(idx, maxheight));
                }
            } else {
                maxheight = 0;
                res.add(Arrays.asList(idx, maxheight));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem218 problem218 = new Problem218();
        List<List<Integer>> res = problem218.solution2(problem218.buildings);
        System.out.println(res);
    }
}
