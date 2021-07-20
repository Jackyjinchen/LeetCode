import java.util.Arrays;
// 1877. 数组中最大数对和的最小值
class Problem1877 {

    public int solutionNum = 1;

    int[] nums = {3,5,4,2,4,6};

    public int solution1(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0, j = nums.length - 1; i < j ; i++,j--) {
            res = Math.max(res, nums[i] + nums[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem1877 pro = new Problem1877();
        int res = pro.solution1(pro.nums);
        System.out.println(res);
    }




}