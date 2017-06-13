package ArrayGroup.SubArray;

/**
 * Created by baiwe on 2017/6/13.
 */
public class MaximumSubArray {
    public int max(int[] nums){
        if (nums.length == 0 || nums == null){
            return 0;
        }
        int max = Integer.MIN_VALUE, sum = 0, minsum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum - minsum);
            minsum = Math.min(minsum, sum);
        }
        return max;
    }
}
