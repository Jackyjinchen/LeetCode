import java.util.Arrays;

// 1838. 最高频元素的频数
class Problem1838 {

    public int solutionNum = 3;

    int[] nums = {1, 2, 4};
    int k = 5;

    public static int solution1(int[] nums, int k) {
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int sum = nums[0];
        int left = 0, right = 1;
        int res = 1;
        while (right < nums.length) {
            while (left >= 0) {
                if (nums[right] * (right - left) - sum <= k) {
                    res = Math.max(res, right - left + 1);
                    if (left == 0) {
                        break;
                    } else {
                        sum += nums[--left];
                    }
                } else {
                    break;
                }
            }
            sum += nums[right++];
            sum -= nums[left++];
        }
        return res;
    }

    public static int solution2(int[] nums, int k) throws Exception {
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int sum = nums[1] - nums[0];
        int left = 0, right = 1;
        int res = 1;
        while (right < nums.length) {
            System.out.println(left + " " + right);
            if (sum <= k) {
                res = right - left + 1;

            } else if ((right - left) > res) {
                sum -= (nums[right] - nums[left++]);
                continue;
            }
            right++;
            if (right < nums.length) {
                sum += (nums[right] - nums[right - 1]) * (right - left);
            } else break;
        }
        return res;
    }


    // LeetCode官方解法
    public static int solution3(int[] nums, int k) throws Exception {
        if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int sum = 0;
        int left = 0;
        int res = 1;
        for (int right = 1; right < nums.length; right++) {
            sum += (nums[right] - nums[right - 1]) * (right - left);
            while (sum > k) {
                sum -= (nums[right] - nums[left++]);
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }


}