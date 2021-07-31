import java.util.*;

// 987. 二叉树的垂序遍历
public class Problem987 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        System.out.println(verticalTraversal(t1));

    }

    static Map<Integer, ArrayList<int[]>> map = new HashMap<>();;

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        for (Integer col : keyList) {
            List<Integer> colList = new ArrayList<>();
            ArrayList<int[]> temp = map.get(col);
            Collections.sort(temp, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] != o2[0]) {
                        return o1[0]-o2[0];
                    } else {
                        return o1[1]-o2[1];
                    }
                }
            });
            for (int[] ints : temp) {
                colList.add(ints[1]);
            }
            res.add(colList);
        }

        return res;
    }

    private static void dfs(TreeNode node, int row, int col) {
        if (node == null) return;
        int[] res = new int[]{row, node.val};
        ArrayList<int[]> resList = map.getOrDefault(col, new ArrayList<>());
        resList.add(res);
        map.put(col, resList);
        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);


    }

}
