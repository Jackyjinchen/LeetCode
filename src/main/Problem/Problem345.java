/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/19
 * @Content:
 */
public class Problem345 {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }
    public static String reverseVowels(String s) {
        String dict = "aeiouAEIOU";
        char[] str = s.toCharArray();
        int low = 0, height = s.length()-1;
        while (low<height) {
            if(dict.indexOf(s.charAt(low))==-1){
                low++;
            } else if(dict.indexOf(s.charAt(height))==-1){
                height--;
            }else {
                char temp = str[low];
                str[low] = str[height];
                str[height] = temp;
                low++;
                height--;
            }
        }
        return String.valueOf(str);
    }
}
