package MISC.StringGroup;

/**
 * Created by baiwe on 2017/6/1.
 */
public class MajorityElementII {
    public int majority(int[] nums){
        int count1 = 0, count2 = 0;
        int candidate1 = -1, candidate2 = -2;

        for (int i = 0; i < nums.length; i++){
//            if (count1 == 0){
//                candidate1 = nums[i];
//                count1 = 1;
//            } else if (count2 == 0){
//                candidate2 = nums[i];
//                count2 = 1;
//            } else if (candidate1 == nums[i]){
//                count1++;
//            } else if (candidate2 == nums[i]){
//                count2++;
//            } else {
//                count1--;
//                count2--;
//            }
            if (candidate1 == nums[i]){
                count1++;
            } else if (candidate2 == nums[i]){
                count2++;
            } else if (count1 == 0){
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0){
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < nums.length; i++){
            if (candidate1 == nums[i]){
                count1++;
            } else if (candidate2 == nums[i]){
                count2++;
            }
        }

        return count1 > count2 ? candidate1 : candidate2;
    }
}
