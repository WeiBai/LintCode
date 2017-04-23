package BinaryTreeGroup;

import sun.reflect.generics.tree.Tree;

/**
 * Created by Wei on 2017/4/23.
 */
public class MaxDepth {
    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        root.left = left;
        root.right = right;
        left.right = node4;

        MaxDepth md = new MaxDepth();
        int depth = md.maxDepth(root);
        System.out.println(depth);
    }
}
