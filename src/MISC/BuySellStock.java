package MISC;

/**
 * Created by baiwe on 2017/6/1.
 */
public class BuySellStock {
    public int maxProfit(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        int profit = 0;
        int min= nums[0];

        for (int i = 1; i < nums.length; i++){
            profit = Math.max(profit, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return profit;
    }
}
