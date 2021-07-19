public class BinarySearch {
    static int[] nums = {1, 2, 5, 6, 8, 15, 22, 22, 26, 27};
    static int target = 22;

    public static void main(String[] args) {
        int result = leftBound(nums, target);
        System.out.println(result);

    }
    // 标准的二分查找搜索
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        // [left, right]
        while (left <= right) {
            int mid = (left + right)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            }
        }
        return  -1;
    }

    // 二分查找左端点
    // 实际上找的是 >=target 的值的位置
    static int leftBound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;
        // [left, right)
        while (left < right) {
            int mid = (left + right)/2;
            if(nums[mid] == target) {
                // 向左找，要保留这一位target相等的值
                right = mid;
            } else if(nums[mid] < target) {
                // 往右找和标准二分相同
                left = mid + 1;
            } else if(nums[mid] > target) {
                // 保留这一位是处理当target不存在，而当前位是
                // >=target 左端点的情况
                right = mid;
            }
        }
        return left;
    }

    // 二分查找右端点
    // 实际上找的是 >target 的值的位置
    int rightBound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length;
        // [left, right)
        while (left < right) {
            int mid = (left + right)/2;
            if(nums[mid] == target) {
                left = mid + 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }
}

