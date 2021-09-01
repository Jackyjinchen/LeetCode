/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/9/1
 * @Content: 165. 比较版本号
 * 两种方式： 1. 直接splice后进行数据比较，这样需要对于切分后的数据占用O(m+n)的存储空间
 *          2. 双指针，只需要存储指针和加和信息即可，存储空间O(1)
 */
public class Problem165 {

    public static void main(String[] args) {
        String version1 = "1.0.1", version2 = "1.1";
        System.out.println(compareVersion(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        int m = version1.length(), n = version2.length();
        int p = 0, q = 0;
        while (p < m || q < n) {
            int x = 0, y = 0;
            while (p < m && version1.charAt(p) != '.') {
                x = 10 * x + version1.charAt(p) - '0';
                p++;
            }
            p++;
            while (q < n && version2.charAt(q) != '.') {
                y = 10 * y + version2.charAt(q) - '0';
                q++;
            }
            q++;
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
