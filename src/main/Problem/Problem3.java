import java.util.HashMap;
import java.util.Map;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/12/20
 * @Content:
 */
public class Problem3 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int lens = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < lens; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(j - i + 1, ans);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
