package BinarySearch;

/**
 * Created by Wei on 2017/4/25.
 */
public class ClassicalBinarySearch {

    public static void main(String[] args){
        int[] input = {1,3,5,7,8};
        ClassicalBinarySearch cbs = new ClassicalBinarySearch();
        int result = cbs.findPosition(input, 7);
        System.out.println(result);
    }

    public int findPosition(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length;
        int mid;

        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if (nums[mid] >= target){
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target){
            return start;
        }

        if (nums[end] == target){
            return end;
        }
        return -1;
    }
}
