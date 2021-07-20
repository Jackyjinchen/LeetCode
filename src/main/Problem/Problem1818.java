import java.util.Arrays;

// 1818. 绝对差值和
public class Problem1818 {
    public int solutionNum = 3;

    int[] nums1 = {1,28,21};
    int[] nums2 = {9,21,20};

    public int solution1(int[] nums1, int[] nums2) {
        int max = 0, maxpos = 0;
        int temp;
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            temp = Math.abs(nums1[i] - nums2[i]);
            res += temp;
            if (temp > max) {
                max = temp;
                maxpos = i;
            }
        }
        System.out.println("总和为：" + res);
        Arrays.sort(nums1);
        int bound = lower_bound(nums1, nums2[maxpos]);
        System.out.println("bound:" + bound);
        System.out.println(res - max + bound);
        return (res - max + bound) % ((int) Math.pow(10, 9) + 7);
    }

    public int lower_bound(int[] nums, int target) {
        int res;
        int pre = 0, pos = nums.length;
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
