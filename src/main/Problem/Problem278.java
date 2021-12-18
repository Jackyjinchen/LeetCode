/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/12/18
 * @Content: 278. 第一个错误的版本
 */
public class Problem278 {

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }


    public static int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(left)) {
                return left;
            }
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /* The isBadVersion API is defined in the parent class VersionControl.
          boolean isBadVersion(int version); */
    private static boolean isBadVersion(int version) {
        return version >= 4;
    }
}
