
import java.util.HashSet;
import java.util.Set;

public class Problem91 {

    public static void main(String[] args) {
        String s = "0";
        System.out.println(numDecodings(s));
    }

    static int ans = 0;
    static int len;

    public static int numDecodings(String s) {

        len = s.length();
        numDecodings(s, 0);
        return ans;
    }

    private static void numDecodings(String s, int pos) {
        if (pos == len) {
            ans++;
            return;
        }
        if (s.charAt(pos) > '0' && s.charAt(pos) <= '9') {
            numDecodings(s, pos + 1);
            if (pos + 1 < len && s.charAt(0) > '0' && s.charAt(0) < '3' && s.charAt(1) < '7') {
                numDecodings(s, pos + 2);
            }
        }
    }

    public int solution(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c=f[i]
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }
}
