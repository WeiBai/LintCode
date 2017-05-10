package SegmentTreeGroup;

/**
 * Created by baiwe on 2017/5/10.
 */
public class SegmentTreeBuild {
    public SegmentTreeNode build(int start, int end){
        if (start > end){
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start != end){
            int mid = (start + end) / 2;

            root.left = build(start, mid);
            root.right = build(mid + 1, end);
        }

        return root;
    }
}

class SegmentTreeNode{
    int start, end;
    SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end){
        this.start = start;
        this.end = end;
        left = null;
        right = null;
    }
}
