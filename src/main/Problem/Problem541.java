/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/20
 * @Content: 541. 反转字符串 II
 */
public class Problem541 {

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }

    public static String reverseStr(String s, int k) {
        int len = s.length() - 1;
        char[] str = s.toCharArray();
        for (int i = 0; i <= len; i += 2 * k) {
            reverse(str, i, Math.min(i + k - 1, len));
        }
        return String.valueOf(str);
    }

    private static void reverse(char[] str, int pre, int pos) {
        while (pre < pos) {
            char temp = str[pre];
            str[pre] = str[pos];
            str[pos] = temp;
            pre++;
            pos--;
        }
    }
}
