import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/9/15
 * @Content: 524. 通过删除字母匹配到字典里最长单词
 */
public class Problem524 {

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale", "apple", "monkey", "plea");
        System.out.println(findLongestWord(s, dictionary));

    }

    // 在此基础上可以先排序，然后在直接寻找第一个符合的字符串
    public static String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String word : dictionary) {
            int p1 = 0, p2= 0;
            while (p1<s.length() && p2<word.length()) {
                if(s.charAt(p1) == word.charAt(p2)) {
                    p2 ++;
                }
                p1++;
            }
            if(p2 == word.length()) {
                if(word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0)) {
                    res = word;
                }
            }
        }

        return res;
    }
}
