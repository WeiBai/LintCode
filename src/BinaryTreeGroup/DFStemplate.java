package BinaryTreeGroup;

/**
 * Created by Wei on 2017/4/23.
 */
public class DFStemplate {

    public ResultType traversal(TreeNode root){
        // null or leaf
        if (root == null){
            // do something and return
        }

        // Divide
        ResultType left = traversal(root.left);
        ResultType right = traversal(root.right);

        // Conquer
        ResultType result = null;
        // ResultType result = Merge from left and right.
        return result;
    }

    static class ResultType{

    }
}
