// 171. Excel表列序号
public class Problem171 {

    public static void main(String[] args) {
        String columnTitle = "FXSHRXW";
        System.out.println(titleToNumber(columnTitle));
    }

    public static int titleToNumber(String columnTitle) {
        int ans = 0;
        for (int pos = columnTitle.length() - 1; pos >= 0; pos--) {
            ans+=Math.pow(26,columnTitle.length()-1-pos)*(columnTitle.charAt(pos) - 'A' + 1);
        }

        return ans;
    }
}
