import java.util.*;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/7
 * @Content: 376. 摆动序列
 */
public class Problem376 {

    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength1(nums));

    }

    public static int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        if (n == 2) return nums[0] == nums[1] ? 1 : 2;
        int len = 1;
        int i = 1;

        while (i < n && nums[i] == nums[i - 1]) {
            i++;
        }
        if(i == n) return 1;
        int pos = nums[i];
        int sub = nums[i] - nums[i-1];
        len++;
        for (++i; i < nums.length; i++) {
            int subx = nums[i] - pos;
            if (sub * subx < 0) {
                len++;
                sub = -sub;
            }
            pos = nums[i];
        }

        return len;
    }

    public static int wiggleMaxLength1(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int sub = nums[1] - nums[0];
        int len = sub == 0 ? 1 : 2;
        for (int i = 2 ; i < n; i++) {
            int subx = nums[i] - nums[i-1];
            if ((subx > 0 && sub <= 0) || (subx < 0 && sub >= 0)) {
                len++;
                sub = subx;
            }
        }

        return len;
    }
}
