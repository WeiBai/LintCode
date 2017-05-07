package DynamicProgramming;

/**
 * Created by Wei on 2017/5/8.
 */
public class MaximumProductSubarray {

    public int maxSubarray(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        max[0] = min[0] = nums[0]; // keypoint
        int result = nums[0];
        for (int i = 1; i < nums.length; i++){
            min[i] = max[i] = nums[i];
            if (nums[i] > 0){
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0){
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            result = Math.max(max[i], result);
        }

        return result;
    }
}
