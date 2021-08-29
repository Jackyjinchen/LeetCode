import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/29
 * @Content: 1588. 所有奇数长度子数组的和
 * 暴力搜索的每次都需要重复计算3、5、7……个数字的和
 * 通过前缀和可以直接计算出值，下降一个运算数量级。
 * 想起了另一个，二维数组的前缀和。
 */
public class Problem1588 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};
        System.out.println(sumOddLengthSubarrays(arr));
    }

    public static int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] tix = new int[n+1];
        for (int i = 0; i < n; i++) {
            tix[i+1] = tix[i] + arr[i];
        }
        int sum = 0;
        for (int start = 0; start < n; start++) {
            for (int len = 1; start + len <= n; len += 2) {
                int end = start + len - 1;
                sum += tix[end + 1] - tix[start];
            }
        }
        return sum;
    }
}
