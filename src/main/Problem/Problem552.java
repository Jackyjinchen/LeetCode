import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/18
 * @Content: 552. 学生出勤记录 II
 */
public class Problem552 {

    public static void main(String[] args) {
        int n = 10101;
        System.out.println(checkRecord(n));
    }

    public static int checkRecord(int n) {
        int mod = 1000000007;
        long[][] dp = new long[2][3];
        dp[0][0] = 1;
        for (int i = 1; i < n+1; i++) {
            long[][] newDp = new long[2][3];
            newDp[0][0] = (dp[0][0] + dp[0][1] + dp[0][2]) % mod;
            newDp[1][0] = (dp[1][0] + dp[1][1] + dp[1][2] + dp[0][0] + dp[0][1] + dp[0][2]) % mod;
            newDp[0][1] = dp[0][0];
            newDp[0][2] = dp[0][1];
            newDp[1][1] = dp[1][0];
            newDp[1][2] = dp[1][1];
            dp = newDp;
        }

        int ans = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans = (ans + (int)dp[i][j]) % mod;
            }
        }

        return ans;
    }

}
