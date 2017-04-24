package BinaryTreeGroup.BinarySearchTree;

import BinaryTreeGroup.BFSBinaryTree;
import BinaryTreeGroup.TreeNode;

import java.util.ArrayList;

/**
 * Created by baiwe on 2017/4/24.
 */
public class ConvertArrayToBST {
    // convert a sorted array to binary search tree

    public static void main(String[] args){
        int[] input = {1,2,3,4,5,6,7};
        TreeNode root = new TreeNode(0);
        ConvertArrayToBST cab = new ConvertArrayToBST();
        root = cab.convert(input);

        BFSBinaryTree bt = new BFSBinaryTree();
        ArrayList<ArrayList<Integer>> result = bt.treeLevel(root);
        for (ArrayList<Integer> arr : result){
            for (Integer num : arr){
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }

    private TreeNode convert(int[] array){
        if (array.length == 0){
            return new TreeNode(-1);
        }
        TreeNode root = new TreeNode(0);
        root = helper(array, 1, array.length, root);

        return root;
    }

    private TreeNode helper(int[] array, int left, int right, TreeNode root){

        if (left <= right) { // keypoint
            int middle = (left + right) / 2;
            root = new TreeNode(array[middle - 1]);
            root.left = helper(array, left, middle - 1, root.left);
            root.right = helper(array, middle + 1, right, root.right);
        }
        return root;

    }
}
