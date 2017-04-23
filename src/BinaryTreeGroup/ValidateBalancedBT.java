package BinaryTreeGroup;

/**
 * Created by Wei on 2017/4/23.
 */
public class ValidateBalancedBT {

    public static void main(String[] args){

        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.right = node4;
        left.right.right = node5;

        ValidateBalancedBT vb = new ValidateBalancedBT();
        boolean result = vb.isBalanced(root);

        System.out.println(result);

    }

    public boolean isBalanced(TreeNode root){
        if (maxDepth(root) == -1){
            return false;
        }else {
            return true;
        }
    }

    public int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if (leftDepth == -1 || rightDepth == -1 || Math.abs((leftDepth - rightDepth)) > 1){
            return -1;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
