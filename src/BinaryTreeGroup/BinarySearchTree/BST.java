package BinaryTreeGroup.BinarySearchTree;

/**
 * Created by baiwe on 2017/4/24.
 */
public class BST<Key extends Comparable<Key>, Value>{
    private TreeNode root;

    private class TreeNode{
        private Key key;
        private Value val;
        private TreeNode left, right;
        private int size;

        public TreeNode(Key key, Value val, int size){
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BST(){
    }

    // Removes the specified key and
    // its associated value from this symbol table
    // if the key is in this symbol table
    public void delete(Key key){
        if (key == null) {
            throw new IllegalArgumentException();
        }
        root = delete(root, key);
    }

    private TreeNode delete(TreeNode x, Key key){
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0){
            x.left = delete(x.left, key);
        } else if (cmp > 0){
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            TreeNode t = x;
            x = min(x.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    private TreeNode min(TreeNode x){
        if (x.left == null) {
            return x;
        } else{
            return min(x.left);
        }
    }

    private TreeNode deleteMin(TreeNode x){
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    private TreeNode put(TreeNode x, Key key, Value val){
        if (x == null){
            return new TreeNode(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    private int size(TreeNode x){
        if (x == null) {
            return 0;
        }
        else {
            return x.size;
        }
    }
}

