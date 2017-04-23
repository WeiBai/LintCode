package BinaryTreeGroup;

import java.util.ArrayList;

/**
 * Created by Wei on 2017/4/23.
 */
public class PreOrder {

    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        ArrayList<TreeNode> result = new ArrayList<TreeNode>();

        PreOrder po = new PreOrder();
        result = po.traverse(root, result);
        for (TreeNode tn : result){
            System.out.println(tn.val);
        }
    }

    public ArrayList<TreeNode> traverse(TreeNode treenode, ArrayList<TreeNode> result){
        if (treenode == null){
            return result;
        }

        result.add(treenode);
        traverse(treenode.left,result);
        traverse(treenode.right,result);

        return result;
    }
}
