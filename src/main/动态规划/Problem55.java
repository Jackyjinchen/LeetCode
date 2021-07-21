// 55. 跳跃游戏
public class Problem55 {
    public int solutionNum = 1;

    int[] sums = {1, 2, 3, 1, 1, 1, 0};

    public boolean solution1(int[] nums) {
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n) {
                n = 1;
            } else {
                n++;
            }
            if (i == 0 && n > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean solution2(int[] nums) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxLen) {
                maxLen = Math.max(maxLen, nums[i] + i);
                if (maxLen >= (nums.length - 1)) return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {
        Problem55 problem55 = new Problem55();
        System.out.println(problem55.solution2(problem55.sums));
    }
}
