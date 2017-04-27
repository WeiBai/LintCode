package DFSGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baiwe on 2017/4/27.
 */
public class Permutation {

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null){
            return result;
        }

        if (nums.length == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }

        Arrays.sort(nums);
        helper(result, new ArrayList<Integer>(), nums);

        return result;
    }

    public void helper(List<List<Integer>> result,
                       ArrayList<Integer> list,
                       int[] nums){

        if (list.size() == nums.length){
            result.add(new ArrayList<Integer>(list));
        }

        for (int i = 0; i < nums.length; i++){
            if (list.contains(nums[i])){
                continue;
            }

            list.add(nums[i]);
            helper(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
}
