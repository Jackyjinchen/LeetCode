import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/12/24
 * @Content:
 */
public class Problem542 {

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] ans = updateMatrix(mat);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }

    public static int[][] updateMatrix(int[][] mat) {

        return mat;
    }
}
