package BinaryTreeGroup;

import LinkedListGroup.ListNode;

/**
 * Created by Wei on 2017/4/23.
 */
public class MaximumPathSum {

    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(80);
        root.left = left;
        root.left.left = node6;
        root.right = right;
        left.right = node4;
        left.right.right = node5;

        MaximumPathSum mps = new MaximumPathSum();
        ReturnType rt = mps.maxSum(root);

        System.out.println(rt.maxPath);
    }

    public ReturnType maxSum(TreeNode root){
        if (root == null){
            return new ReturnType(0, Integer.MIN_VALUE);
        }

        // divide
        ReturnType left = maxSum(root.left);
        ReturnType right = maxSum(root.right);

        // conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);

        return new ReturnType(singlePath, maxPath);
    }

    static class ReturnType{
        int singlePath;
        int maxPath;

        public ReturnType(int singlePath, int maxPath){
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
}
