// 263. 丑数
public class Problem263 {

    public static void main(String[] args) {
        int n = 14;
        System.out.println(isUgly(n));
    }

    public static boolean isUgly(int n) {
        if(n<=0) return false;
        int[] maps = {2,3,5};
        for (int map : maps) {
            while (n%map==0){
                n/=map;
            }
        }
        if(n == 1) return true;

        return false;

    }
}
