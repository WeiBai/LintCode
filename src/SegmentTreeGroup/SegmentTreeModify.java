package SegmentTreeGroup;

/**
 * Created by Wei on 2017/5/16.
 */
public class SegmentTreeModify {
    public void modify(SegmentTreeNodeII root, int index, int value){
        if (root.start == index && root.end == index){
            root.max = value;
            return;
        }

        int mid = (root.start + root.end) / 2;
        if (index <= mid){
            modify(root.left, index, value);
            root.max = Math.max(root.left.max, root.right.max);
        } else {
            modify(root.right, index, value);
            root.max = Math.max(root.left.max, root.right.max);
        }
        return;
    }
}
