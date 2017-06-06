package MISC;

/**
 * Created by Wei on 2017/6/6.
 */
public class BuySellStockII {
    public int totalProfit(int[] nums){
        int profit = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] - nums[i - 1] > 0){
                profit += nums[i] - nums[i - 1];
            }
        }
        return profit;
    }
}
