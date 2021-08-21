/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/22
 * @Content: 789. 逃脱阻碍者
 */
public class Problem789 {

    public static void main(String[] args) {
        int[][] ghosts = {{1, 0}, {0, 3}};
        int[] target = {0, 1};
        System.out.println(escapeGhosts(ghosts, target));
    }

    public static boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = getDistance(new int[]{0,0},target);
        for (int[] ghost : ghosts) {
            if(getDistance(ghost,target) <= distance) return false;
        }

        return true;
    }

    private static int getDistance(int[] ghost, int[] target) {
        return Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
    }
}
