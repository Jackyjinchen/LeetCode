import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/9
 * @Content: 313. 超级丑数
 */
public class Problem313 {

    public static void main(String[] args) {
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        System.out.println(nthSuperUglyNumber(n, primes));
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        int[] p = new int[primes.length];
        Arrays.fill(p, 1);
        int[] num = new int[primes.length];
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                num[j] = dp[p[j]] * primes[j];
                if (num[j] < min) {
                    min = num[j];
                }
            }
            for (int k = 0; k < primes.length; k++) {
                if (num[k] == min) p[k]++;
            }
            dp[i] = min;
        }

        return dp[n];
    }
}
