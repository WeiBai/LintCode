package BinaryTreeGroup.BinarySearchTree;

import BinaryTreeGroup.TreeNode;

/**
 * Created by baiwe on 2017/4/24.
 */
public class ValidateBST {

    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);

        root.left = left;
        root.right = right;
       

        ValidateBST bst = new ValidateBST();
        boolean result = bst.isValidate(root);
        System.out.println(result);

    }

    private boolean isValidate(TreeNode root){
        return  helperValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private boolean helperValid(TreeNode root, double min, double max){
        if (root == null) {
            return true;
        }

        if (root.val <= min || root.val >= max){
            return false;
        }

        return helperValid(root.left, min, root.val) &&
                helperValid(root.right, root.val, max);
    }
}
