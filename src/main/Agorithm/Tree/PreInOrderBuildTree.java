package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PreInOrderBuildTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        PreInOrderBuildTree preInOrderBuildTree = new PreInOrderBuildTree();
        TreeNode root = preInOrderBuildTree.buildTree(preorder, inorder);
        preInOrderBuildTree.levelOrder(root);
    }

    HashMap<Integer, Integer> memo = new HashMap<>();
    int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) memo.put(inorder[i], i);
        pre = preorder;
        TreeNode root = buildTree(0, preorder.length - 1, 0, pre.length - 1);
        return root;
    }

    public TreeNode buildTree(int ps, int pe, int is, int ie) {
        if (ie < is) return null;

        int root = pre[ps];
        // 这里起到快速下标的目的，默认不存在相同值的节点。
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(ps + 1, ps + ri - is, is, ri - 1);
        node.right = buildTree(ps + ri - is+1, pe, ri + 1, ie);
        return node;
    }

    public void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.println(root.val);
            if (root.left != null) {
                queue.offer(root.left);
            }
            if (root.right != null) {
                queue.offer(root.right);
            }
        }
    }


}
