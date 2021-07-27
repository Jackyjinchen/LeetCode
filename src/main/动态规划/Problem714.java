// 714. 买卖股票的最佳时机含手续费
public class Problem714 {

    public static void main(String[] args) {
        int[] prices = {1, 3, 7, 5, 10, 3};
        int fee = 3;
        Problem714 problem714 = new Problem714();
        System.out.println(problem714.solution1(prices, fee));
    }

    public int solution1(int[] prices, int fee) {
        int buy = -prices[0] - fee, sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, sell - prices[i] - fee);
            sell = Math.max(sell, buy + prices[i]);
            System.out.println(buy + " " + sell);
        }
        return sell;
    }
}
