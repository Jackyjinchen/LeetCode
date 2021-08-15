/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/15
 * @Content: 576. 出界的路径数
 */
public class Problem576 {

    static int ans = 0;

    public static void main(String[] args) {
        int m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1;
        System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 1000000007;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ans = 0;
        int[][][] dp = new int[maxMove + 1][m][n];
        dp[0][startRow][startColumn] = 1;
        for (int i = 0; i < maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int count = dp[i][j][k];
                    if (count > 0) {
                        for (int[] direction : directions) {
                            int j1 = j + direction[0], k1 = k + direction[1];
                            if (j1 >= 0 && j1 < m && k1 >= 0 && k1 < n) {
                                dp[i + 1][j1][k1] = (dp[i + 1][j1][k1] + count) % MOD;
                            } else {
                                ans = (ans + count) % MOD;
                            }
                        }
                    }
                }
            }
        }

        return ans;
    }

    public static int findPathsOutOfTime(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove < 1 || startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) return ans;
        if (maxMove > 0) {
            if (startRow == 0) ans++;
            if (startRow == m - 1) ans++;
            if (startColumn == 0) ans++;
            if (startColumn == n - 1) ans++;
        }
        findPathsOutOfTime(m, n, maxMove - 1, startRow - 1, startColumn);
        findPathsOutOfTime(m, n, maxMove - 1, startRow, startColumn - 1);
        findPathsOutOfTime(m, n, maxMove - 1, startRow + 1, startColumn);
        findPathsOutOfTime(m, n, maxMove - 1, startRow, startColumn + 1);


        return ans;
    }


}
