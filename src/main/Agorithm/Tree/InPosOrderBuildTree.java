package Tree;

import java.util.HashMap;
import java.util.Stack;

public class InPosOrderBuildTree {

    private int orderSize;
    private int[] inorder;
    private int[] postorder;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        InPosOrderBuildTree inPosOrderBuildTree = new InPosOrderBuildTree();
        TreeNode root = inPosOrderBuildTree.buildTree1(inorder, postorder);
    }

    /**
     * solution1
     */
    private TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = null;
        orderSize = inorder.length;
        int postorderSize = postorder.length;
        if (orderSize == 0 || orderSize != postorderSize) {
            return null;
        }
        this.inorder = inorder;
        this.postorder = postorder;
        root = myBuildTree(0, orderSize - 1, 0, orderSize - 1);
        return root;
    }

    private TreeNode myBuildTree(int inorderBegin, int inorderEnd, int postorderBegin, int postorderEnd) {
        TreeNode root = null;
        if (inorderBegin == inorderEnd) {
            root = new TreeNode(inorder[inorderBegin]);
        } else if (inorderBegin < inorderEnd) {
            root = new TreeNode(postorder[postorderEnd]);
            int tempValue = postorder[postorderEnd];
            int rootIndex = inorderBegin;
            while (rootIndex < inorderEnd && inorder[rootIndex] != tempValue) {
                ++rootIndex;
            }
            int leftCnt = rootIndex - inorderBegin;
            root.left = myBuildTree(inorderBegin, rootIndex - 1, postorderBegin, postorderBegin + leftCnt - 1);
            root.right = myBuildTree(rootIndex + 1, inorderEnd, postorderBegin + leftCnt, postorderEnd - 1);
        }

        return root;
    }

    /**
     * solution2
     */
    HashMap<Integer,Integer> memo = new HashMap<>();
    int[] post;

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        for(int i = 0;i < inorder.length; i++) memo.put(inorder[i], i);
        post = postorder;
        TreeNode root = buildTree1(0, inorder.length - 1, 0, post.length - 1);
        return root;
    }

    public TreeNode buildTree1(int is, int ie, int ps, int pe) {
        if(ie < is) return null;

        int root = post[pe];
        // 这里起到快速下标的目的，默认不存在相同值的节点。
        int ri = memo.get(root);

        TreeNode node = new TreeNode(root);
        node.left = buildTree1(is, ri - 1, ps, ps + ri - is - 1);
        node.right = buildTree1(ri + 1, ie, ps + ri - is, pe - 1);
        return node;
    }
}
