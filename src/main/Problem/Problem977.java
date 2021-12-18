import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/12/18
 * @Content: 977. 有序数组的平方
 */
public class Problem977 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7,-3,2,3,11})));
    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1, index = right;
        int[] ans = new int[nums.length];
        while (left <= right) {
            if(nums[left] * nums[left] >= nums[right] * nums[right]) {
                ans[index--] = nums[left] * nums[left];
                left++;
            } else {
                ans[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return ans;
    }
}
