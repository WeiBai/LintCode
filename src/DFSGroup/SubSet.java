package DFSGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baiwe on 2017/4/27.
 */
public class SubSet {

    public List<List<Integer>> subset(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null){
            return result;
        }

        if (nums.length == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }

        Arrays.sort(nums);
        helper(result, new ArrayList<Integer>(), nums, 0);

        return result;
    }

    public void helper(List<List<Integer>> result,
                       ArrayList<Integer> list,
                       int[] nums,
                       int start){

        result.add(new ArrayList<Integer>(list));

        for (int i = start; i < nums.length ; i++){
            list.add(nums[i]);
            helper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
