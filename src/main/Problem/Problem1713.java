import java.lang.annotation.Target;
import java.util.*;

// 1713. 得到子序列的最少操作次数
public class Problem1713 {
    public int solutionNum = 1;

    // 会超时
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
            ret = Math.min(findIndex(arr, index + 1, target, 1 + targetIndex),
                    Math.min(findIndex(arr, start, target, 1 + targetIndex) + 1, findIndex(arr, index + 1, target, targetIndex)));
        }

        return ret;
    }

    private int findFirst(int[] arr, int start, int target) {
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public int solution2(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> pos = new HashMap<>();
        // arr[5, 2, -1, 6, 3, 7, 2, 3, -1, -1]
        for (int i = 0; i < n; i++) {
            pos.put(target[i], i);
        }
        // 最长递增序列 方法很巧妙 这里可以参考300题
        // [5] add
        // [2] set
        // [2, 6] add
        // [2, 3] set
        // [2, 3, 7] add
        // [2, 3, 7] set
        // [2, 3, 7] set
        List<Integer> d = new ArrayList<>();
        for (int val : arr) {
            if (pos.containsKey(val)) {
                int idx = pos.get(val);
                int it = binarySearch(d, idx);
                if(it != d.size()) {
                    d.set(it,idx);
                    System.out.println(d.toString()+ " set");
                } else {
                    d.add(idx);
                    System.out.println(d.toString()+ " add");
                }

            }
        }
        return n - d.size();
    }

    private int binarySearch(List<Integer> d, int target) {
        int size = d.size();
        if (size == 0 || d.get(size - 1) < target) return size;
        int low = 0, high = size - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if(d.get(mid)<target) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        int[] target = {5, 10, 8, 11, 3, 15, 9, 20, 18, 13};
        int[] arr = {15, 8, 2, 9, 11, 20, 8, 11, 7, 2};
        Problem1713 problem1713 = new Problem1713();
        System.out.println("res" + problem1713.solution2(target, arr));
    }
}
