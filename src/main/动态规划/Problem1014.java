import java.util.Arrays;

// 1014. 最佳观光组合
public class Problem1014 {

    public int solution1(int[] values) {

        // 内存超标
        int n = values.length;
        int[][] dp = new int[n][n];
        dp[0][1] = values[0] + values[1] + 0 - 1;
        int max = dp[0][1];
        if (n == 2) return dp[0][1];
        for (int i = 2; i < values.length; i++) {
            dp[0][i] = dp[0][i - 1] - values[i - 1] + values[i] - 1;
            max = Math.max(max, dp[0][i]);
            for (int j = 1; j < i; j++) {
                dp[j][i] = dp[j - 1][i] - values[j - 1] + values[j] + 1;
                max = Math.max(max, dp[j][i]);
            }
        }
        // [0, 8, 11, 7, 10]
        // [0, 0, 5, 1, 4]
        // [0, 0, 0, 6, 9]
        // [0, 0, 0, 0, 7]
        // [0, 0, 0, 0, 0]
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
        return max;
    }

    // 时间超标
    public int solution2(int[] values) {
        int n = values.length;
        // 用一个数组来存储
        int[] dp = new int[n];
        dp[0] = values[0] + values[1] + 0 - 1;
        int max = dp[0];
        if (n == 2) return dp[0];
        for (int i = 2; i < values.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                dp[j] = dp[j] - values[i - 1] + values[i] - 1;
                max = Math.max(max, dp[j]);
            }
            dp[i - 1] = dp[i - 2] - values[i - 2] + values[i - 1] + 1;
            max = Math.max(max, dp[i - 1]);
            System.out.println(Arrays.toString(dp));
        }
        return max;
    }

    // 可以拆分成 values[i] + i 和 values[j] - j 两部分，零两部分都是最大就可以最大化结果
    public int solution3(int[] values) {
        int ans = 0, mx = values[0] + 0;
        for (int j = 1; j < values.length; ++j) {
            ans = Math.max(ans, mx + values[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, values[j] + j);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] values = {8, 1, 5, 2, 6};
        Problem1014 problem1014 = new Problem1014();
        System.out.println(problem1014.solution3(values));
    }
}
