package Tree;

import java.util.*;

public class BinaryTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 递归遍历二叉树
     */
    // 先序遍历
    public void preOrderRecursive(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }

    // 中序遍历
    public void inOrderRecursive(TreeNode root) {
        if (root == null) return;
        inOrderRecursive(root.left);
        System.out.println(root.val);
        inOrderRecursive(root.right);
    }

    // 后序遍历
    public void postOrderRecursive(TreeNode root) {
        if (root == null) return;
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.println(root.val);
    }

    /**
     * 非递归遍历二叉树
     */
    // 先序遍历
    public void preOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.println(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    // 中序遍历 可以理解为图的DFS 使用Stack先进后出的特点
    public void inOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    // 后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null) {
                stack1.push(root.left);
            }
            if (root.right != null) {
                stack1.push(root.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().val);
        }
    }

    // 后序遍历 思路2
    // 要访问一个节点的条件上一个访问的节点是右儿子。我们可以增加一个变量Prev来判断当前节点Curr的上一个节点与它的关系来执行相应的操作。
    // 若Prev为空(Curr节点是根节点)或者Prev是Curr的父节点，将Curr节点的左孩子和右孩子分别压入栈；
    // 若Prev是Curr的左儿子，则将Curr的右儿子压入栈；
    // 否则Prev是Curr的右儿子，访问Curr;
    public void postOrder2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null, curr = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                }
            } else {
                System.out.println(curr.val);
                stack.pop();
            }
            prev = curr;
        }
    }

    // 层序遍历二叉树 可以理解为图的BFS 通过队列先进先出的特点
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

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.levelOrder(t1);

    }
}
