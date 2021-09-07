/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/9/7
 * @Content: 1221. 分割平衡字符串
 */
public class Problem1221 {

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.println(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        int ans = 0, sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = s.charAt(i) == 'R' ? ++sum : --sum;
            if(sum == 0) ans++;
        }

        return ans;
    }
}
