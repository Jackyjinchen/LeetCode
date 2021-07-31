import java.util.*;


// 1337. 矩阵中战斗力最弱的 K 行
public class Problem1337 {

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        int k = 3;
        System.out.println(Arrays.toString(kWeakestRows(mat, k)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;

        List<int[]> power = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1, pos = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (mat[i][mid] == 0) {
                    r = mid - 1;
                } else {
                    pos = mid;
                    l = mid + 1;
                }
            }
            power.add(new int[]{pos + 1, i});
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(m, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                else return o1[1] - o2[1];
            }
        });

        for (int[] ints : power) {
            heap.offer(ints);
        }
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll()[1];
        }
        return ans;
    }
}
