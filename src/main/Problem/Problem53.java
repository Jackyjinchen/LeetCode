import java.util.Arrays;

// 剑指 Offer 42. 连续子数组的最大和
// 53. 最大子序和
class Problem53 {

    public int solutionNum = 1;

    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

    public int solution1(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for(int x : nums) {
            sum = Math.max(x, x + sum);
            max = Math.max(max, sum);
        }
        return max;
    }




}