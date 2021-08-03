import java.util.Arrays;

// 62. 不同路径
public class Problem62 {
    public static void main(String[] args) {
        int m = 1, n = 3;
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int[][] dp = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int mx = i - 1 == 0 ? 1 : dp[i - 1][j];
                int nx = j - 1 == 0 ? 1 : dp[i][j - 1];
                dp[i][j] = mx + nx;
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        return dp[m-1][n-1];
    }
}
