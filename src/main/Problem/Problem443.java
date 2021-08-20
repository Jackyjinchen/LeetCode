import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/21
 * @Content: 443. 压缩字符串
 */
public class Problem443 {
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        int ans = 0;
        int index = 0;
        int indexChar = 0;
        while (index < chars.length) {
            int j = index + 1;
            while (j < chars.length && chars[j] == chars[index]) {
                j++;
            }
            char[] temp = ((j - index) + "").toCharArray();
            ans += temp.length;
//            System.out.println(indexChar +" " + Arrays.toString(temp));

            chars[indexChar++] = chars[index];
            if(j - index != 1) {
                ++ans;
                for (char c : temp) {
                    chars[indexChar++] = c;
                }
            };
            index = j;
        }
//        System.out.println(chars);
        return ans;
    }

}
