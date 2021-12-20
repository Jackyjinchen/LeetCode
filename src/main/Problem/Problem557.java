import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/12/20
 * @Content: 557. 反转字符串中的单词 III
 */
public class Problem557 {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }

    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        while (right <= chars.length) {
            if (right == chars.length || chars[right] == ' ') {
                reverse(chars, left, right - 1);
                left = right + 1;
            }
            right++;
        }
        return new String(chars);
    }

    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
