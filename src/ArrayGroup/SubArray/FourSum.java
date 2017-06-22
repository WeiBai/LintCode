package ArrayGroup.SubArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by baiwe on 2017/6/22.
 */
public class FourSum {
    public ArrayList<ArrayList<Integer>> sum(int[] nums, int target){
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 4){
            return results;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++){
                if (j > i + 1 && nums[j] == nums[j-1]){
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        results.add(list);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return results;
    }
}
