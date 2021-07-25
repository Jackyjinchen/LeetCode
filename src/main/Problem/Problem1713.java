import sun.security.util.ArrayUtil;

import java.util.Arrays;

// 1713. 得到子序列的最少操作次数
public class Problem1713 {
    public int solutionNum = 1;

    public int solution1(int[] target, int[] arr) {
        return findIndex(arr, 0, target, 0);
    }

    private int findIndex(int[] arr, int start, int[] target, int targetIndex) {
        if (targetIndex > target.length - 1) return 0;
        int ret = 0;
        int index = findFirst(arr, start, target[targetIndex]);
        if (index == -1) {
            ret = findIndex(arr, start, target, 1 + targetIndex) + 1;
        } else {
            ret = Math.min(findIndex(arr, index + 1, target, 1 + targetIndex), Math.min(findIndex(arr, start, target, 1 + targetIndex) + 1, findIndex(arr, index + 1, target, targetIndex)));
        }

        return ret;
    }

    private int findFirst(int[] arr, int start, int target) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] target = {5, 10, 8, 11, 3, 15, 9, 20, 18, 13};
        int[] arr = {15, 8, 2, 9, 11, 20, 8, 11, 7, 2};
        Problem1713 problem1713 = new Problem1713();
        System.out.println("res" + problem1713.solution1(target, arr));
    }
}
