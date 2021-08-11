/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/11
 * @Content: 200 岛屿数量
 */
public class Problem200 {

    private static int m;
    private static int n;

    public static void main(String[] args) {
        char[][] grid = {{
                '1', '1', '1', '1', '0'
        }, {
                '1', '1', '0', '1', '0'
        }, {
                '1', '1', '0', '0', '0'
        }, {
                '0', '0', '0', '0', '0'
        }};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }
    private static void dfs(int i, int j, char[][] grid){
        if( i < 0 || j < 0 || i == m || j == n) return;
        if(grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(i, j+1, grid);
            dfs(i+1, j, grid);
            dfs(i-1, j, grid);
            dfs(i, j-1, grid);
        }

    }
}
