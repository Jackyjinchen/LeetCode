import java.util.Arrays;

// 63. 不同路径 II
public class Problem63 {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        obstacleGrid[0][0] = 1 - obstacleGrid[0][0];
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = obstacleGrid[i][0] == 1 ? 0 : obstacleGrid[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = obstacleGrid[0][i] == 1 ? 0 :obstacleGrid[0][i - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        for (int[] so : obstacleGrid) {
            System.out.println(Arrays.toString(so));
        }

        return obstacleGrid[m - 1][n - 1];
    }

}
