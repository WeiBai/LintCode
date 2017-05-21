package ArrayGroup;

/**
 * Created by Wei on 2017/5/22.
 */
class TwoSumii{
    public int[] sum(int[] nums, int target){
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int select = nums[i];
            int second = binarySearch(nums, target - nums[i], i + 1);
            if (second != -1) {
                result[0] = i + 1;
                result[1] = second + 1;
                return result;
            }
        }
        return null;
    }

    public int binarySearch(int[] nums, int target, int start){
        int begin = start;
        int end = nums.length - 1;
        int mid;

        while(begin + 1 < end){
            mid = begin + (end - begin) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                begin = mid;
            }
        }

        if (nums[begin] == target) {
            return begin;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
