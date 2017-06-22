package ArrayGroup.SubArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by baiwe on 2017/6/22.
 */
public class ThreeSum {
    public ArrayList<ArrayList<Integer>> sum(int[] nums){
        //output
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        //exception and corner case
        if (nums == null || nums.length == 0 || nums.length < 3){
            return result;
        }
        //sort
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            twoSum(nums, left, right, target, result);
        }
        return result;
    }

    public void twoSum(int[] nums,
                        int left,
                        int right,
                        int target,
                        ArrayList<ArrayList<Integer>> result){
        while (left < right){
            if (target == nums[left] + nums[right]){
                ArrayList<Integer> triple = new ArrayList<>();
                triple.add(-target);
                triple.add(nums[left]);
                triple.add(nums[right]);
                result.add(triple);
                left++;
                right--;

                while (left < right && nums[left] == nums[left-1]){
                    left++;
                }
                while (left < right && nums[right] == nums[right + 1]){
                    right--;
                }
            } else if (target < nums[left] + nums[right]){
                right--;
            } else {
                left++;
            }
        }
    }
}
