import java.util.ArrayList;
import java.util.List;
// 119. 杨辉三角 II
public class Problem119 {

    public static void main(String[] args) {
        int rowIndex = 0;
        System.out.println(getRow(rowIndex+1));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < rowIndex; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(j - 1) + ret.get(j));
                }
            }
            ret = row;
        }
        return ret;
    }
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }

}
