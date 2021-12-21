import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/12/20
 * @Content: 567. 字符串的排列
 */
public class Problem567 {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;
        int[] cnt1 = new int[26], cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            ++cnt1[s1.charAt(i) - 'a'];
            ++cnt2[s2.charAt(i) - 'a'];
        }
        if(Arrays.equals(cnt1,cnt2)) return true;
        for (int i = n; i < m; i++) {
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i-n) - 'a'];
            if(Arrays.equals(cnt1,cnt2)) return true;
        }
        return false;
    }
}
