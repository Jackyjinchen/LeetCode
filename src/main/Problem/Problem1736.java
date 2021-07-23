import java.util.Arrays;

// 1736. 替换隐藏数字得到的最晚时间
public class Problem1736 {
    public int solutionNum = 1;

    public String solution1(String time) {
        char[] arr = time.toCharArray();
        if (arr[0] == '?') {
            arr[0] = ('4' <= arr[1] && arr[1] <= '9') ? '1' : '2';
        }
        if (arr[1] == '?') {
            arr[1] = (arr[0] == '2') ? '3' : '9';
        }
        if (arr[3] == '?') {
            arr[3] = '5';
        }
        if(arr[4]== '?') {
            arr[4] = '9';
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String time = "2?:?0";
        Problem1736 problem1736 = new Problem1736();
        System.out.println(problem1736.solution1(time));
    }
}
