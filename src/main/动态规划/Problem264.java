import java.util.*;

// 264. 丑数 II
public class Problem264 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n));
    }

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) p2++;
            if (dp[i] == num3) p3++;
            if (dp[i] == num5) p5++;

        }
        return dp[n];

    }

    public static int nthUglyNumber2(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

}
