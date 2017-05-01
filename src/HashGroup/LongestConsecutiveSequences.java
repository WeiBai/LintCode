package HashGroup;

import java.util.HashSet;

/**
 * Created by Wei on 2017/5/2.
 */
public class LongestConsecutiveSequences {
    public int longestConsecutive(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }

        HashSet hs = new HashSet();

        for (int i = 0; i < nums.length; i++){
            hs.add(nums[i]);
        }
        int longest = 0;

        for (int i = 0; i < nums.length; i++){
            int down = nums[i] - 1;
            while (hs.contains(down)){
                hs.remove(down);
                down--;
            }

            int up = nums[i] + 1;
            while (hs.contains(up)){
                hs.remove(up);
                up++;
            }

            longest = Math.max(longest, up - down - 1);
        }

        return longest;
    }
}
