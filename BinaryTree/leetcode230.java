package BinaryTree;

import ListNode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class leetcode230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> treeNodes =  new ArrayList<>();
        preorder(root , treeNodes);
        return treeNodes.get(k - 1);
    }
    public void preorder(TreeNode node , List<Integer> res){
        if(node == null) return;
        preorder(node.left, res);
        res.add(node.val);
        preorder(node.right,res);
    }
}
