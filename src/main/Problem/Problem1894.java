/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/9/10
 * @Content: 1894. 找到需要补充粉笔的学生编号
 * 直接遍历，或者可以采用前缀数据和之后二分查找的方式
 */
public class Problem1894 {

    public static void main(String[] args) {
        int[] chalk = {5, 1, 5};
        int k = 22;
        System.out.println(chalkReplacer(chalk, k));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        int res = -1;
        for (int num : chalk) {
            sum += num;
        }
        k %= sum;
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                res = i;
                break;
            }
            k -= chalk[i];
        }
        return res;
    }

    // 前缀和+二分查找
    public static int chalkReplacer2(int[] chalk, int k) {
        int n = chalk.length;
        if (chalk[0] > k) return 0;
        for (int i = 1; i < n; i++) {
            chalk[i] += chalk[i - 1];
            if (chalk[i] > k) return i;
        }
        k %= chalk[n - 1];
        return binarySearch(chalk, k);
    }

    public static int binarySearch(int[] chalk, int k) {
        int left = 0, right = chalk.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(chalk[mid] <= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
