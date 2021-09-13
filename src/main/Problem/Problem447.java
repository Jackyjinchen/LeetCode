import java.util.HashMap;
import java.util.Map;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/9/13
 * @Content: 447. 回旋镖的数量
 * 距离相等，存储每一个为端点距离的数量map，A 2 n为有序的数量
 */
public class Problem447 {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangs(points));
    }

    public static int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int[] p : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] q : points) {
                int dis2 = (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
                map.put(dis2, map.getOrDefault(dis2, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int n = entry.getValue();
                res += n * (n - 1);
            }
        }
        return res;
    }

}
