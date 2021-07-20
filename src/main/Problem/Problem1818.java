import java.util.Arrays;

// 1818. 绝对差值和
public class Problem1818 {
    public int solutionNum = 3;

    int[] nums1 = {1, 28, 21};
    int[] nums2 = {9, 21, 20};

    public int solution1(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int max = 0;
        int temp;
        int res = 0;
        int n = nums1.length;
        int[] numsCopy = new int[n];
        System.arraycopy(nums1, 0, numsCopy, 0, n);
        Arrays.sort(numsCopy);
        for (int i = 0; i < n; i++) {
            temp = Math.abs(nums1[i] - nums2[i]);
            res = (res + temp) % MOD;

            max = Math.max(max, temp - lower_bound(numsCopy, nums2[i]));

        }
        return (res - max + MOD) % MOD;
    }

    public int lower_bound(int[] nums, int target) {
        int pre = 0, pos = nums.length - 1;
        while (pre < pos) {
            int mid = pre + (pos - pre) / 2;
            if (nums[mid] < target) {
                pre = mid + 1;
            } else if (nums[mid] >= target) {
                pos = mid;
            }
        }
        if (pre == 0) {
            return Math.abs(target - nums[pre]);
        } else {
            return Math.min(Math.abs(target - nums[pre]), Math.abs(target - nums[pre - 1]));
        }
    }

    public static void main(String[] args) {
        Problem1818 pro = new Problem1818();
        System.out.println("res=" + pro.solution1(pro.nums1, pro.nums2));
    }

}
