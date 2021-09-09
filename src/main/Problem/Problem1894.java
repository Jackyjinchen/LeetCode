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
            if(chalk[i] > k) {
                res = i;
                break;
            }
            k -= chalk[i];
        }
        return res;
    }
}
