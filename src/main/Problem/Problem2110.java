import java.util.*;

// 面试题 10.02. 变位词组
public class Problem2110 {

    String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

    public int solutionNum = 1;

    public List<List<String>> solution1(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
