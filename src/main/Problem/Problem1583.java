import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/14
 * @Content: 1583. 统计不开心的朋友
 */
public class Problem1583 {

    public static void main(String[] args) {
        int n = 4;
        int[][] preferences = {{1,2,3},{3,2,0},{3,1,0},{1,2,0}};
        int[][] pairs ={{0,1},{2,3}};
        System.out.println(unhappyFriends(n,preferences,pairs));
    }

    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int ans = 0;
        int[][] order = new int[n][n];
        int[] match = new int[n];
        // 获得亲近程度的表
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                order[i][preferences[i][j]] = j+1;
            }
        }
        // 获取配对的表
        for (int[] pair : pairs) {
            match[pair[0]] = pair[1];
            match[pair[1]] = pair[0];
        }
        for (int i = 0; i < n; i++) {
            // 找到与朋友 x 配对的朋友 y
            // 找到朋友 y 在朋友 x 的朋友列表中的亲近程度下标，记为 index。
            int index = order[i][match[i]];
            for (int j = 0; j < index; j++) {
                int u = preferences[i][j];
                int v = match[u];
                if(order[u][i] < order[u][v]) {
                    ans++;
                    break;
                }
            }

        }

        return ans;
    }

}
