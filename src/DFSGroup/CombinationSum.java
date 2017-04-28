package DFSGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baiwe on 2017/4/28.
 */
public class CombinationSum {

    public List<List<Integer>> csum(int[] nums, int target){
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null){
            return result;
        }
        if (nums.length == 0){
            result.add(new ArrayList<Integer>());
        }

        Arrays.sort(nums);

        helper(result, new ArrayList<Integer>(), nums, 0, target);
        return result;
    }

    public void helper(List<List<Integer>> result,
                       ArrayList<Integer> list,
                       int[] nums,
                        int pos,
                       int target){

        if (target == 0){
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = pos; i < nums.length; i++){
            if (i != pos && nums[i] == nums[i - 1]){
                continue;
            }

            if (nums[i] > target){
                break;
            }

            list.add(nums[i]);
            helper(result, list, nums, i,target - nums[i]); // update the value of position
            list.remove(list.size() - 1);
        }

    }
}
