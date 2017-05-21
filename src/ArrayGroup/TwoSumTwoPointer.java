package ArrayGroup;

/**
 * Created by Wei on 2017/5/22.
 */
class TwoSumTwoPointer{
    public int[] sum(int[] nums, int target){
        if (nums == null || nums.length == 0) {
            return null;
        }
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[2];
        while(start < end){
            if (nums[start] + nums[end] == target) {
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            } else if(nums[start] + nums[end] > target){
                end--;
            } else if(nums[start] + nums[end] < target){
                start++;
            }
        }
        return null;
    }
}
