package SegmentTreeGroup;

/**
 * Created by baiwe on 2017/5/12.
 */
public class SegmentTreeQueryII {
    public int query(SegmentTreeNodeII root, int start, int end){
        if (start <= root.start && root.end <= end){
            return root.max;
        }

        int result = Integer.MIN_VALUE;
        int mid = (root.start + root.end) / 2;
        if (mid >= start){
            result = Math.max(result, query(root.left, start, end));
        }
        if (mid + 1 <= end){
            result = Math.max(result, query(root.right, start, end));
        }

        return result;
    }
}
