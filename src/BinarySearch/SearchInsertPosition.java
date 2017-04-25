package BinarySearch;

/**
 * Created by baiwe on 2017/4/25.
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (nums[mid] == target){
                return mid; // keypoint
            } else if (nums[mid] > target){
                end = mid;
            } else {
                start = mid;
            }
        }

        // keypoint
        if (nums[start] >= target){
            return start;
        }
        else if (nums[end] >= target){
            return end;
        } else {
            return end + 1;
        }
    }
}
