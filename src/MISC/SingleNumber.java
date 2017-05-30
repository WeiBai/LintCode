package MISC;

/**
 * Created by baiwe on 2017/5/30.
 */
public class SingleNumber {
    public int single(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }
}
