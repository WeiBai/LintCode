package ArrayGroup.SubArray;

/**
 * Created by baiwe on 2017/6/21.
 */
public class MaximumSubArrayIII {
    public int maxSum(int[] nums, int k){
        if (nums.length < k){
            return 0;
        }

        int[][] localMax = new int[nums.length + 1][k + 1];
        int[][] globMax = new int[nums.length + 1][k + 1];

        for (int j = 1; j <= k; j++){
            localMax[j-1][j] = Integer.MIN_VALUE; // initialize
            for (int i = j; i <= nums.length; i++){
                localMax[i][j] = Math.max(globMax[i - 1][j - 1], localMax[i - 1][j]) + nums[i - 1];
                if (i == j){
                    globMax[i][j] = localMax[i][j];
                } else {
                    globMax[i][j] = Math.max(globMax[i - 1][j],localMax[i][j]);
                }
            }
        }
        return globMax[nums.length][k];
    }
}
