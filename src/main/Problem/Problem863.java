import java.util.*;
// 863. 二叉树中所有距离为 K 的结点
public class Problem863 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static TreeNode root;
    static TreeNode target;
    static List<Integer> res;
    static int k;

    public static void main(String[] args) {

        String input = "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]";
        int k = 1;
        String targetStr = "2";
        String[] str = input.split("\\[")[1].split("\\]")[0].split(", ");
        buildTree(str, targetStr);
        System.out.println(new Problem863().solution1(root, target, k));

//        System.out.println(new Problem863().solution1(root, target, k));

    }

    private static void buildTree(String[] str, String targetStr) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = new TreeNode(Integer.parseInt(str[0]));
        if (str[0].equals(targetStr)) target = node;
        root = node;
        queue.offer(node);
        int index = 1;
        while (!queue.isEmpty() && index < str.length) {
            TreeNode parent = queue.poll();
            if (!str[index].equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(str[index]));
                if (str[index].equals(targetStr)) target = parent.left;
                queue.offer(parent.left);
            }
            index++;
            if (!str[index].equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(str[index]));
                if (str[index].equals(targetStr)) target = parent.right;
                queue.offer(parent.right);
            }
            index++;
        }

    }

    public List<Integer> solution1(TreeNode root, TreeNode target, int k) {
        res = new ArrayList<>();
        Problem863.k = k;
        findParents(root);

        return res;
    }

    private int findParents(TreeNode node) {
        if (node == null) return -1;
        if (node == target) {
            findAns(node, k);
            return k - 1;
        }
        int left = findParents(node.left);
        int right = findParents(node.right);
        if (left > 0) {
            findAns(node.right, left - 1);
            return left - 1;
        } else if (left==0){
            res.add(node.val);
        }
        if (right > 0) {
            findAns(node.left, right - 1);
            return right - 1;
        } else if (right==0){
            res.add(node.val);
        }
        return -1;
    }

    private void findAns(TreeNode node, int i) {
        if (i < 0 || node == null) return;
        if (i == 0) {
            res.add(node.val);
        } else {
            findAns(node.left, i - 1);
            findAns(node.right, i - 1);
        }

    }


}
