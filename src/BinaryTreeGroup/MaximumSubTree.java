package BinaryTreeGroup;

/**
 * Created by baiwe on 2017/6/28.
 */
public class MaximumSubTree {

    TreeNode result = null;
    int maxWeight = Integer.MIN_VALUE;

    public TreeNode maxSubTree(TreeNode root){
        helper(root);
        return result;
    }

    public int helper(TreeNode root){
        if (root == null){
            return 0; // keypoint
        }

        int leftWeight = helper(root.left);
        int rightWeight = helper(root.right);

        if (leftWeight + rightWeight + root.val > maxWeight){
            maxWeight = leftWeight + rightWeight + root.val;
            result = root;
        }

        return leftWeight + rightWeight + root.val;
    }
}
