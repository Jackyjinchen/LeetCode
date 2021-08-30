import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/30
 * @Content: 528. 按权重随机选择
 * 前缀和可以解决概率的边界值。随机一个总和范围内的
 * 数字，然后通过二分查找来找到这个值位于哪个区间。
 */
public class Problem528 {
    public static void main(String[] args) {
        int[] w = {1, 3};
        Solution solution = new Solution(w);
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }

    static class Solution {
        int[] prefix;
        int sum;

        public Solution(int[] w) {
            int len = w.length;
            prefix = new int[len];
            prefix[0] = w[0];
            for (int i = 1; i < len; i++) {
                prefix[i] = prefix[i - 1] + w[i];
            }
            sum = Arrays.stream(w).sum();

        }

        public int pickIndex() {
            int x = (int) (Math.random() * sum) + 1;
            return binarySearch(x);
        }

        //  1 2 3 4     具体数字
        // 1-2-3-4-5    区间范围
        // 需要4个数中随机，有5个边界0-4，找到边界值
        private int binarySearch(int x) {
            int left = 0, right = prefix.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid] < x) {
                    left = mid + 1 ;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}
