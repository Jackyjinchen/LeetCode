// 45. 跳跃游戏 II
public class Problem45 {
    public int solutionNum = 1;

    int[] sums = {2,1,9};

    public int solution1(int[] nums) {
        if (nums.length == 1) return 0;
        int res = 1;
        int pos = 0;
        int max = nums[0];

        while (max < (nums.length - 1)) {
            int temp = pos + 1;
            pos = max;
            res++;
            for (int i = temp; i <= pos; i++) {
                max = Math.max(nums[i] + i, max);
//                if (max >= nums.length - 1) return res;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Problem45 problem45 = new Problem45();
        System.out.println("结果"+problem45.solution1(problem45.sums));
    }
}
