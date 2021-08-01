import java.util.Arrays;
import java.util.Collections;

// 931. 下降路径最小和
public class Problem931 {

    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(minFallingPathSum(matrix));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n == 1)return matrix[0][0];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            matrix[i][0] = matrix[i][0] + Math.min(matrix[i-1][0],matrix[i-1][1]);
            for (int j = 1; j < n-1; j++) {
                matrix[i][j] = matrix[i][j] + Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j],matrix[i-1][j+1]));
            }
            matrix[i][n-1] = matrix[i][n-1] + Math.min(matrix[i-1][n-2],matrix[i-1][n-1]);
        }
        Arrays.sort(matrix[n-1]);

        return matrix[n-1][0];
    }

    /**
     * 官方题解边界条件判断的很好
     */
    public int minFallingPathSum1(int[][] A) {
        int N = A.length;
        for (int r = N-2; r >= 0; --r) {
            for (int c = 0; c < N; ++c) {
                // best = min(A[r+1][c-1], A[r+1][c], A[r+1][c+1])
                int best = A[r+1][c];
                if (c > 0)
                    best = Math.min(best, A[r+1][c-1]);
                if (c+1 < N)
                    best = Math.min(best, A[r+1][c+1]);
                A[r][c] += best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x: A[0])
            ans = Math.min(ans, x);
        return ans;
    }

}
