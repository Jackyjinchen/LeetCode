import java.util.Arrays;

class Problem34 {

    public int solutionNum = 1;

    int[] nums = {5, 7, 7, 8, 8, 10};
    int target = 7;


    int[] res = {-1, -1};

    public void solution1() {
        int len = nums.length;
        if (len == 0 || target < nums[0] || target > nums[len - 1]) {
//            return res;
        } else {
            res = recursive(0, len - 1);
        }
        System.out.println(Arrays.toString(res));
    }

    public int[] recursive(int start, int end) {
        int middle = (start + end) / 2;
        if (nums[middle] > target && start != end) {
            res = recursive(start, middle - 1);
        } else if (nums[middle] < target && start != end) {
            res = recursive(middle + 1, end);
        } else if (nums[middle] == target) {
            start = middle;
            end = middle;
            while (start >= 0) {
                if (nums[start] == target) {
                    --start;
                } else {
                    break;
                }
            }
            while (end < nums.length) {
                if (nums[end] == target) {
                    ++end;
                } else {
                    break;
                }
            }
            res[0] = start + 1;
            res[1] = end - 1;
        }
        return res;
    }


}