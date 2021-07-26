// 121. 买卖股票的最佳时机
public class Problem121 {

    public int solution1(int[] prices) {
        if (prices.length <= 1) return 0;
        int ans = 0, min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            ans = Math.max(ans, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        Problem121 problem121 = new Problem121();
        System.out.println(problem121.solution1(prices));
    }
}
