package SegmentTreeGroup;

/**
 * Created by baiwe on 2017/5/11.
 */
public class SegmentTreeBuildII {

    public SegmentTreeNodeII build(int[] A){
        return helper(0, A.length - 1, A);
    }

    public SegmentTreeNodeII helper(int start, int end, int[] array){
        if (start > end){
            return null;
        }

        SegmentTreeNodeII root = new SegmentTreeNodeII(start, end, Integer.MIN_VALUE);

        if (start != end){
            int mid = (start + end) / 2;
            root.left = helper(start, mid, array);
            root.right = helper(mid + 1, end, array);
            root.max = Math.max(root.left.max, root.right.max);
            // root.min = Math.min(root.left.min, root.right.min);
            // root.sum = root.left.sum + root.right.sum;
        } else {
            root.max = array[start];
        }
        return root;
    }
}

class SegmentTreeNodeII{
    int start, end, max;
    SegmentTreeNodeII left, right;

    public SegmentTreeNodeII(int start, int end, int max){
        this.start = start;
        this.end = end;
        this.max = max;
        this.left = null;
        this.right = null;
    }
}
