// 152. 乘积最大子数组
public class Problem152 {
    public int solutionNum = 1;

    public int solution1(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,-5,-2,-4,3};
        Problem152 problem152 = new Problem152();
        System.out.println(problem152.solution1(nums));
    }
}
