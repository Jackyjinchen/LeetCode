import java.util.ArrayList;
import java.util.Arrays;


// 188. 买卖股票的最佳时机 IV
public class Problem188 {

    public int solution1(int[] prices, int k) {
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        for (int i = 0; i < buy.length; i++) {
            buy[i] = Integer.MIN_VALUE;
        }
        System.out.println(Arrays.toString(buy));
        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j < k + 1; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        System.out.println(Arrays.toString(sell));
        return sell[k];
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        Problem188 problem188 = new Problem188();
        System.out.println(problem188.solution1(prices, k));
    }
}
