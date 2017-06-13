package ArrayGroup.SubArray;

import java.util.ArrayList;

/**
 * Created by baiwe on 2017/6/13.
 */
public class MaximumSubArrayII {
    public int max(ArrayList<Integer> nums){
        int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];

        int sum = 0, minSum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            left[i] = max;
        }

        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = nums.size() - 1; i >= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            right[i] = max;
        }

        max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size() - 1; i++){
            max = Math.max(max, left[i] + right[i+1]);
        }
        return max;
    }
}
