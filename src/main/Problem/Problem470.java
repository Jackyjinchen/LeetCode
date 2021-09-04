/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/9/5
 * @Content: 470. 用 Rand7() 实现 Rand10()
 */
public class Problem470 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(rand10f3());
        }
    }

    public static int rand7() {
        return (int) (Math.random() * 7 + 1);
    }


    //   枚举如下：
    //  	a	1	2	3	4	5	6	7
    //  b
    //  1		2	3	4	5	6	7	8
    //  2		3	4	5	6	7	8	9
    //  3		4	5	6	7	8	9	0
    //  4		5	6	7	8	9	0	1
    //  5		6	7	8	9	0	1	2
    //  6		7	8	9	0	1	2	3
    //  7		8	9	0	1	2	3	4
    //  去掉右上角的
    //  6	7	8
    //  7	8	9
    //  8	9	0      后
    //  每个数字的出现次数为4次，0-9的概率相同
    //  所以程序思路就很明了,当结果扫到右上角的时候进行递归调用，直到输出其他结果
    public static int rand10() {
        int a = rand7(), b = rand7();
        if (a > 4 && b < 4) return rand10();
        else return (a + b) % 10 + 1;
    }

    // a的目的是使用1-5的数字，相同的概率
    // b是最大化取值，1-6中奇偶的概率都是二分之一
    // 在上面的基础上，如果是偶数就返回a，否则返回a+5（6-10范围）。
    public static int rand10f2() {
        int a = rand7(), b = rand7();
        while (a > 5) a = rand7();
        while (b > 6) b = rand7();
        return b % 2 == 0 ? a : a + 5;
    }

    // 暴力，此方法得到的概率不相等。
    // 调用 10 次 rand7() 生成的数在 10 ~ 70 之间（包含 70，一共 61 个数），如果模上 10 的话，可以看到数字 0 出现的比其它数字多 1。
    public static int rand10f3() {
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans += rand7();
        }
        return ans % 10 + 1;
    }


}
