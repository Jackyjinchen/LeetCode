// 122. 买卖股票的最佳时机 II
public class Problem122 {

    // 贪心算法，直接加完了
    public int solution1(int[] prices) {
        if (prices.length <= 1) return 0;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] - prices[i-1] > 0) {
                ans += prices[i] - prices[i-1];
            }
        }
        return ans;
    }

    // 动态规划
    public int solution2(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        // dp0指的是在这一天之前已经卖出了股票
        // dp1指的是在这一天还没有卖出股票的获利
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 新的
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        Problem122 problem122 = new Problem122();
        System.out.println(problem122.solution2(prices));
    }
}
