import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/31
 * @Content: 1109. 航班预订统计
 * 逆向思维，前缀和是从a到b每一位都加上上一位加上的值，
 * 那么在第一位加上，在最后一位减去即可。
 */
public class Problem1109 {
    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        System.out.println(Arrays.toString(corpFlightBookings(bookings, n)));
    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }

        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }


        return nums;
    }
}
