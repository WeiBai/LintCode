package DFSGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baiwe on 2017/4/28.
 */
public class PermutationTwo {

    public List<List<Integer>> permute(int[] nums){
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums == null){
            return result;
        }
        if (nums.length == 0){
            result.add(new ArrayList<Integer>());
            return result;
        }

        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            visited[i] = false;
        }

        Arrays.sort(nums);

        helper(result, new ArrayList<Integer>(), nums, visited);

        return result;
    }

    private void helper(List<List<Integer>> result,
                        ArrayList<Integer> list,
                        int[] nums,
                        boolean[] visited){

        if (list.size() == nums.length){
            result.add(new ArrayList<Integer>(list));
        }

        for (int i = 0; i < nums.length; i++){
            if (visited[i] == true || (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == false)){
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            helper(result, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
