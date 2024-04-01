package BinaryTree;

public class leetcode543 {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        Depth(root);
        return ans - 1;
    }
    public int Depth(TreeNode root){
        if(root == null) return 0;

        int L = Depth(root.left);
        int R = Depth(root.right);
        ans = Math.max(ans , L+R+1);
        return Math.max(L,R) + 1;
    }
}
