
import java.util.HashMap;
import java.util.Map;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/11
 * @Content: 446. 等差数列划分 II - 子序列
 */
public class Problem446 {
    public static void main(String[] args) {
        int[] nums = {2,4,6,8,10};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Map<Long, Integer>[] map = new Map[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long d = 1L * nums[i] - nums[j];
                int cnt = map[j].getOrDefault(d,0);
                ans += cnt;
                map[i].put(d, map[i].getOrDefault(d, 0) + cnt + 1);
            }
        }


        return ans;
    }
}
