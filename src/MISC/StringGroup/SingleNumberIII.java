package MISC.StringGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baiwe on 2017/5/30.
 */
public class SingleNumberIII {
    public List<Integer> single(int[] nums){
        int xor = 0;

        for (int i = 0; i < nums.length; i++){
            xor ^= nums[i];
        }

        int lastone = xor - (xor & (xor - 1));
        int group0 = 0, group1 = 0;

        for (int i = 0; i < nums.length; i++){
            if ((lastone & nums[i]) == 0){
                group0 ^= nums[i];
            } else {
                group1 ^= nums[i];
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(group0);
        result.add(group1);

        return result;
    }
}
