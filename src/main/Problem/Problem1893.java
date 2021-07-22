import java.util.Arrays;
import java.util.Comparator;

// 1893. 检查是否区域内所有整数都被覆盖
public class Problem1893 {
    public int solutionNum = 1;

    int[][] ranges = {{1, 2}, {3, 4}, {5, 6}};
    int left = 2, right = 5;

    public boolean solution1(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        for (int[] range : ranges) {
            if (left > right) return true;
            if (range[0] <= left && left <= range[1]) left = range[1] + 1;
        }

        return left > right;
    }

    public static void main(String[] args) {
        Problem1893 problem1893 = new Problem1893();
        System.out.println(problem1893.solution1(problem1893.ranges, problem1893.left, problem1893.right));
    }
}
