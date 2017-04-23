package BinaryTreeGroup;

/**
 * Created by Wei on 2017/4/23.
 */
public class LCA {

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

        LCA lcaImpl = new LCA();
        TreeNode result = lcaImpl.lca(root, right, node5);
        System.out.println(result.val);
    }

    public TreeNode lca(TreeNode root, TreeNode node1, TreeNode node2){
        if (root == null || root == node1 || root == node2){
            return root;
        }

        // divide
        TreeNode left = lca(root.left, node1, node2);
        TreeNode right = lca(root.right, node1, node2);

        // conquer
        if (left != null && right != null){
            return root;
        }

        if (left != null){
            return left;
        }

        if (right != null){
            return right;
        }

        return null;
    }
}
