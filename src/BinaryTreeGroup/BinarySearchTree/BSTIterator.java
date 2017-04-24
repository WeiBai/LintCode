package BinaryTreeGroup.BinarySearchTree;

import BinaryTreeGroup.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by baiwe on 2017/4/24.
 */
public class BSTIterator {
    //一直加左节点，有右节点的话，继续加右节点的左节点
    Stack<TreeNode> stack  = new Stack<TreeNode>();

    public BSTIterator(TreeNode root){
        while (root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public int next(){
        TreeNode node = stack.pop();
        int value = node.val;
        if (node.right != null){ // keypoint
            node = node.right;
            while(node != null){
                stack.push(node);
                node = node.left;
            }
        }
        return value;
    }
}
