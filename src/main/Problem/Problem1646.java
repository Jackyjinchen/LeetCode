/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/23
 * @Content: 1646. 获取生成数组中的最大值
 */
public class Problem1646 {

    public static void main(String[] args) {
        int n = 7;
        System.out.println(getMaximumGenerated(n));
    }

    public static int getMaximumGenerated(int n) {
        if (n < 2) return n;
        int[] nums = new int[n + 1];
        int max = 0;
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) nums[i] = nums[i / 2];
            else nums[i] = nums[(i - 1) / 2] + nums[(i + 1) / 2];
            max = Math.max(nums[i], max);
        }
        return max;
    }
}
