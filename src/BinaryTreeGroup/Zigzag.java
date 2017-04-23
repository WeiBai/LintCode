package BinaryTreeGroup;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Wei on 2017/4/24.
 */
public class Zigzag {

    public ArrayList<ArrayList<Integer>> zig(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null){
            return result;
        }

        Stack<TreeNode> current = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        Stack<TreeNode> tmp;

        boolean normalorder = true;

        current.push(root);

        while(!current.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();

            while(!current.isEmpty()){
                TreeNode top = current.pop();
                level.add(top.val);
                if (normalorder) {
                    if (top.left != null) {
                        next.push(top.left);
                    }
                    if (top.right != null) {
                        next.push(top.right);
                    }
                } else{
                    if (top.right != null) {
                        next.push(top.right);
                    }
                    if (top.left != null) {
                        next.push(top.left);
                    }
                }
            }

            result.add(level); // keypoint

            tmp = current;
            current = next;
            next = tmp;
            normalorder = !normalorder;

        }
        return result;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.right = node4;
        right.right = node5;

        Zigzag zz = new Zigzag();
        ArrayList<ArrayList<Integer>> result = zz.zig(root);
        for (ArrayList<Integer> arr : result){
            for (Integer num : arr){
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }
}
