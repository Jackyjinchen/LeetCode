package main.Other;

import java.util.*;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/9/10
 * @Content:
 */
public class XieCheng01 {

    public static void main(String[] args) {
        int[] A = {3, 5, 2, 7, 1, 8, 3};
        int k = 4;
        System.out.println(solution(A, k));
    }

    public static int solution(int[] A, int k) {
        int n = A.length;
        List<int[]> list = new LinkedList<>();
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 1; i < n; i++) {
            list.add(new int[]{i - 1, i, Math.min(A[i-1],A[i]), Math.max(A[i-1],A[i])});
        }
        
        return 1;
    }

}
