import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/12/20
 * @Content: 167. 两数之和 II - 输入有序数组
 */
public class Problem167 {

    public static void main(String[] args) {
        int[] numbers = {2,3,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = {1, numbers.length};
        while (ans[0] < ans[1]) {
            int sum = numbers[ans[0]-1] + numbers[ans[1]-1];
            if(sum < target) {
                ans[0]++;
            } else if(sum > target) {
                ans[1]--;
            } else {
                break;
            }
        }
        return ans;
    }
}
