import java.util.Arrays;

// 581. 最短无序连续子数组
public class Problem581 {

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray1(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int[] sort = new int[nums.length];
        System.arraycopy(nums, 0, sort, 0, nums.length);

        Arrays.sort(sort);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] != sort[i]) break;
            i++;
        }
        while (i < j) {
            if (nums[j] != sort[j]) break;
            j--;
        }
        return j == i ? 0 : j - i + 1;
    }

    public static int findUnsortedSubarray1(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
            System.out.println(right+" "+left);
        }
        return right == -1 ? 0 : right - left + 1;
    }
}
