// 309. 最佳买卖股票时机含冷冻期
public class Problem309 {

    public int solution1(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int dp0 = 0, dp1 = -prices[0], dp2 = 0;
        for (int i = 1; i < prices.length; i++) {
            // 新的
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp2 - prices[i]);
            int newDp2 = Math.max(dp0, dp2);
            dp0 = newDp0;
            dp1 = newDp1;
            dp2 = newDp2;
            System.out.println(dp0+" "+dp1+" "+dp2);
        }
        return dp0;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        Problem309 problem309 = new Problem309();
        System.out.println(problem309.solution1(prices));

    }
}
