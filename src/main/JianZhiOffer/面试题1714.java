package main.JianZhiOffer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/9/3
 * @Content: 面试题 17.14. 最小K个数
 * 1. 最简单方式是排序，然后取出k个最小数
 * 2. 可以采用小顶堆，先排序k个数字，其他数再加入，如果小于堆顶，就交换。最终保存的都是k个最小的数。
 */
public class 面试题1714 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        System.out.println(Arrays.toString(smallestK2(arr, k)));
    }

    public static int[] smallestK(int[] arr, int k) {
        int[] ans = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }

        return ans;
    }

    public static int[] smallestK2(int[] arr, int k) {
        int[] ans = new int[k];
        if(k == 0) return ans;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if(queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = queue.poll();
        }

        return ans;
    }
}
