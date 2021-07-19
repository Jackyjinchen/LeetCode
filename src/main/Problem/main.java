import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);

        System.out.println("解答LeetCode题目");
        System.out.println("==============================");
        System.out.println("请输入题号");

        Solution solution = null;
        while (solution == null) {
            try {
                solution = new Solution(input.nextLine());
            } catch (Exception e) {
                System.out.println("没有此题,请重新输入");
            }
        }

        solution.run(input.nextLine());
        input.close();
    }
}
