import java.util.*;

// 300. 最长递增子序列
public class Problem300 {
    public int solutionNum = 1;

    // 贪心+二分查找法
    public int solution1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            int index = binarySearch(list, num);
            if(index != list.size()) {
                list.set(index, num);
            } else {
                list.add(num);
            }
        }
        return list.size();
    }

    private int binarySearch(List<Integer> arr, int target) {
        int n = arr.size();
        if(n==0||arr.get(n-1) < target) return n;
        int low = 0, high = n- 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr.get(mid) < target) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // 动态规划算法
    public int solution2(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] =1;
        int maxans = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] =1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7,7};
        Problem300 problem300 = new Problem300();
        System.out.println(problem300.solution2(nums));
    }
}
