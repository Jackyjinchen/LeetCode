/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/12/23
 * @Content:
 */
public class Problem695 {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, square(grid, i, j));
                }
            }
        }

        return maxArea;

    }

    private static int square(int[][] grid, int x, int y) {
        int square = 0;
        if (grid[x][y] == 0) return 0;
        if (grid[x][y] == 1) {
            grid[x][y] = 2;
            square++;
        }
        if (x - 1 >= 0 && grid[x - 1][y] == 1) {
            square += square(grid, x - 1, y);
        }
        if (x + 1 < grid.length && grid[x + 1][y] == 1) {
            square += square(grid, x + 1, y);
        }
        if (y - 1 >= 0 && grid[x][y - 1] == 1) {
            square += square(grid, x, y - 1);
        }
        if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
            square += square(grid, x, y + 1);
        }
        return square;
    }
}
