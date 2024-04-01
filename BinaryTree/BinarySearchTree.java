package BinaryTree;

import java.util.*;

public class BinarySearchTree {

}

/**
 * leetcode 95.不同的二叉排序树
 */
class Solution1 {
//    public List<TreeNode> generateTrees(int n) {
//        if (n == 0) {
//            return new LinkedList<TreeNode>();
//        }
//        return generateTrees(1, n);
//    }
//
//    public List<TreeNode> generateTrees(int start, int end) {
//        List<TreeNode> allTrees = new LinkedList<TreeNode>();
//        if (start > end) {
//            allTrees.add(null);
//            return allTrees;
//        }
//
//        // 枚举可行根节点
//        for (int i = start; i <= end; i++) {
//            // 获得所有可行的左子树集合
//            List<TreeNode> leftTrees = generateTrees(start, i - 1);
//
//            // 获得所有可行的右子树集合
//            List<TreeNode> rightTrees = generateTrees(i + 1, end);
//
//            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
//            for (TreeNode left : leftTrees) {
//                for (TreeNode right : rightTrees) {
//                    TreeNode currTree = new TreeNode(i);
//                    currTree.left = left;
//                    currTree.right = right;
//                    allTrees.add(currTree);
//                }
//            }
//        }
//        return allTrees;
//    }
    public List<TreeNode> generateTrees(int n){
        if(n == 0) return new LinkedList<>();
        return generateTrees(1,n);
    }
    public List<TreeNode> generateTrees(int begin , int end){
        List<TreeNode> allTrees = new LinkedList<>();
        if(begin > end) {
            allTrees.add(null);
            return allTrees;
        }

        for (int i = begin; i < end; i++) {
            List<TreeNode> leftTrees = generateTrees(begin, i-1);

            List<TreeNode> rightTrees = generateTrees(i+1,end);

            for (TreeNode left : leftTrees){
                for (TreeNode right: rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }

}
class Solution2{
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        return null;
    }
}

