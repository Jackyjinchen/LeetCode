import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/12/20
 * @Content: 283. 移动零
 */
public class Problem283 {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int left = 0, right = 0, lens = nums.length;
        while (right < lens) {
            if(nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }

    public static void moveZeroes2(int[] nums) {
        int zero = 0, index = 0, lens = nums.length - 1;
        while (zero < lens) {
            // 跳到zero
            while (zero <= lens && nums[zero] != 0) {
                zero++;
            }
            index = zero + 1;
            while (index <= lens && nums[index] == 0) {
                index++;
            }
            if (index > lens) return;
            System.out.println(zero);
            int temp = nums[zero];
            nums[zero] = nums[index];
            nums[index] = temp;
            zero++;
        }
    }
}
