public class Problem671 {

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
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
//        t1.left = t2;
//        t1.right = t3;
//        t3.left = t4;
//        t3.right = t5;
        Problem671 problem671 = new Problem671();
        System.out.println(problem671.solution1(t1));
    }

    int ans;
    int rootvalue;

    public int solution1(TreeNode root) {
        ans = -1;
        rootvalue = root.val;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode node) {
        if(node == null) return;
        if(ans != -1 && node.val >= ans) return;
        if(node.val > rootvalue) ans = node.val;
        dfs(node.left);
        dfs(node.right);
    }


}
