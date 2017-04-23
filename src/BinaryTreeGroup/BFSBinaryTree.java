package BinaryTreeGroup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Wei on 2017/4/23.
 */
public class BFSBinaryTree {

    public ArrayList<ArrayList<Integer>> treeLevel(TreeNode root) {
         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

         if (root == null){
             return result;
         }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
         queue.offer(root);
         while (!queue.isEmpty()){
             ArrayList<Integer> level = new ArrayList<Integer>();
             int size = queue.size(); // keypoint
             for (int i=0; i < size; i++) {
                 TreeNode head = queue.poll();
                 level.add(head.val);
                 if (head.left != null) {
                     queue.offer(head.left);
                 }
                 if (head.right != null) {
                     queue.offer(head.right);
                 }
             }
             result.add(level);
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
        left.right.right = node5;

        BFSBinaryTree bt = new BFSBinaryTree();
        ArrayList<ArrayList<Integer>> result = bt.treeLevel(root);
        for (ArrayList<Integer> arr : result){
            for (Integer num : arr){
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }
}
