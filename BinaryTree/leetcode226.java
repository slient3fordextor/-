package BinaryTree;

public class leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode pre = root;
        TreeNode tmp = pre.left;
        pre.left = pre.right;
        pre.right = tmp;

        invertTree(pre.left);
        invertTree(pre.right);

        return root;
    }
}
