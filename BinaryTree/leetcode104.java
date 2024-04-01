package BinaryTree;

public class leetcode104 {
    public int maxDepth(TreeNode root) {
        int ans = 0;
        return cntDepth(root , ans);
    }

    public int cntDepth(TreeNode root , int x){
        int cnt = 0;
        if(root == null) {
            cnt = Math.max(x, cnt);
            return cnt;
        }

        int ans = Math.max(cntDepth(root.left , x+1) , cntDepth(root.right , x+1));

        return ans;
    }
}
