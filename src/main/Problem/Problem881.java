import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: jackyjinchen
 * @Date: 2021/8/26
 * @Content: 881. 救生艇
 */
public class Problem881 {

    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Arrays.sort(people);
        int pre = 0, pos = people.length-1;
        while (pre<=pos){
            if(people[pre]+people[pos] <= limit) {
                pre++;
            }
            pos--;
            ans++;
        }

        return ans;
    }
}
