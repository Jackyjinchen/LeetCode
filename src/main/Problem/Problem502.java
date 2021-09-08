import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/9/8
 * @Content: 502. IPO
 */
public class Problem502 {

    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = {1, 2, 3}, capital = {0, 1, 1};
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int size = profits.length;
        int curr = 0;
        int[][] arr = new int[size][2];
        for (int i = 0; i < size; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i < k; i++) {
            while (curr < size && arr[curr][0] <= w) {
                queue.add(arr[curr][1]);
                curr++;
            }
            if(!queue.isEmpty()) {
                w += queue.poll();
            } else {
                break;
            }
        }

        return w;
    }
}
