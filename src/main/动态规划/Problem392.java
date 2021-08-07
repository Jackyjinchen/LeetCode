/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/7
 * @Content: 392. 判断子序列
 */
public class Problem392 {

    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (s.length() > t.length()) return false;
        int sP = 0, tP = 0;
        while (sP < s.length() && tP < t.length()) {
            if (s.charAt(sP) == t.charAt(tP)) {
                sP++;
            }
            tP++;
        }
        return sP == s.length();
    }

    public static boolean isSubsequence1(String s, String t) {
        int n = s.length(), m = t.length();
        int sP = 0, tP = 0;
        while (sP < n && tP < m) {
            if (s.charAt(sP) == t.charAt(tP)) {
                sP++;
            }
            tP++;
        }
        return sP == n;
    }
}
