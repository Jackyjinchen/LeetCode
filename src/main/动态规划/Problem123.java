import java.util.ArrayList;
import java.util.Arrays;


// 123. 买卖股票的最佳时机 III
public class Problem123 {

    public int solution1(int[] prices) {
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        // 四种情况
        // 第一次买 在上一天不动，或者买入
        // 第一次卖 上一天不动， 或者第一次卖
        // 第二次买 上一天不动，或者第一次卖了之后买入
        // 第二次卖 上一天不动，或者第二次买入后卖出
        for (int i = 1; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1+ prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2+prices[i]);
            System.out.println(buy1+" "+sell1+" "+buy2+" "+sell2);
        }


        return sell2;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        Problem123 problem123 = new Problem123();
        System.out.println(problem123.solution1(prices));
    }
}
