import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/9/9
 * @Content: 68. 文本左右对齐
 * 这玩意儿也叫算法题？？？
 */
public class Problem68 {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(fullJustify(words, maxWidth));

    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<>();
        int right = 0, n = words.length;
        while (true) {
            int left = right;
            int sumLen = 0;
            while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
                sumLen += words[right++].length();
            }

            // 最后一行
            if (right == n) {
                StringBuffer sb = join(words, left, right, " ");
                sb.append(blank(maxWidth - sb.length()));
                list.add(sb.toString());
                return list;
            }

            int numWords = right - left;
            int numSpaces = maxWidth - sumLen;

            if (numWords == 1) {
                StringBuffer sb = new StringBuffer(words[left]);
                sb.append(blank(numSpaces));
                list.add(sb.toString());
                continue;
            }

            int avgSpaces = numSpaces / (numWords - 1);
            int extSpaces = numSpaces % (numWords - 1);
            StringBuffer sb = new StringBuffer();
            sb.append(join(words, left, left + extSpaces + 1, blank(avgSpaces + 1)));
            sb.append(blank(avgSpaces));
            sb.append(join(words, left + extSpaces + 1, right, blank(avgSpaces)));
            list.add(sb.toString());
        }

    }

    // blank 返回长度为 n 的由空格组成的字符串
    public static String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        return sb.toString();
    }

    // join 返回用 sep 拼接 [left, right) 范围内的 words 组成的字符串
    public static StringBuffer join(String[] words, int left, int right, String sep) {
        StringBuffer sb = new StringBuffer(words[left]);
        for (int i = left + 1; i < right; ++i) {
            sb.append(sep);
            sb.append(words[i]);
        }
        return sb;
    }

}
