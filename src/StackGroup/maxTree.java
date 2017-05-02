package StackGroup;

import java.util.Stack;

/**
 * Created by baiwe on 2017/5/2.
 */
public class maxTree {

    public TreeNode max(int[] A){
        if (A == null || A.length == 0){
            return null;
        }

        Stack<TreeNode> stack = new Stack();

        for (int i = 0; i < A.length; i++){
            TreeNode node = new TreeNode(A[i]);

            while (!stack.isEmpty() && node.val > stack.peek().val){
                node.left = stack.pop();
            }

            if (!stack.isEmpty()){
                stack.peek().right = node;
            }

            stack.push(node);
        }

        TreeNode rst = stack.pop();
        while (!stack.isEmpty()){
            rst = stack.pop();
        }
        return rst;
    }
}

class TreeNode{
    int val;
    TreeNode left, right;

    public TreeNode(int val){
        this.val = val;
        left = null;
        right = null;
    }
}