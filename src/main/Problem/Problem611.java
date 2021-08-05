import java.util.Arrays;

// 611. 有效三角形的个数
public class Problem611 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        System.out.println(triangleNumber(nums));
    }

    public static int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int l = j + 1, r = n - 1, k = j;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if (nums[m] >= nums[i] + nums[j]) {
                        r = m - 1;
                    } else {
                        k = m;
                        l = m + 1;
                    }
                }
                ans += k - j;
            }
        }
        return ans;
    }
}
