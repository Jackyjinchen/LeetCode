package Tree;

import java.util.LinkedList;
import java.util.Queue;

// 层序建立一个二叉树
public class LevelOrderBuildTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        String input = "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]";
        String[] str = input.split("\\[")[1].split("\\]")[0].split(", ");
        buildTree(str);

    }

    private static void buildTree(String[] str) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = new TreeNode(Integer.parseInt(str[0]));
        queue.offer(node);
        int index = 1;
        while (!queue.isEmpty() && index < str.length) {
            TreeNode parent = queue.poll();
            if (!str[index].equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(str[index]));
                queue.offer(parent.left);
            }
            index++;
            if (!str[index].equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(str[index]));
                queue.offer(parent.right);
            }
            index++;
        }

    }
}
