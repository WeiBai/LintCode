package MISC;

/**
 * Created by baiwe on 2017/5/31.
 */
public class MajorityElement {
    public int majority(int[] nums){
        int count = 0;
        int candidate = -1;

        for (int i = 0; i < nums.length; i++){
            if (count == 0){
                candidate = nums[i];
                count = 1;
            } else if (candidate == nums[i]){
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
