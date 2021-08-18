/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/17
 * @Content: 551.学生出勤记录
 */
public class Problem551 {

    public static void main(String[] args) {
        String s = "PPALLP";
        System.out.println(checkRecord(s));

    }

    public static boolean checkRecord(String s) {
        int a = 0, l = 0;
        for(int i =0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'L') {
                l++;
                if(l == 3) return false;
            } else {
                l = 0;
                if(ch == 'A') a++;
                if(a>=2) return false;
            }
        }
        return true;
    }

}
