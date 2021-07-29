
// 413. 等差数列划分
public class Problem413 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,8,9,10};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    public static int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        if (nums.length < 3) return ans;
        int diff = nums[1] - nums[0], len = 2;
        int dp = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                ++len;
                dp += len - 2;
            } else {
                ans += dp;
                diff = nums[i] - nums[i - 1];
                len = 2;
                dp = 0;

            }
        }
        ans += dp;
        return ans;
    }
}
