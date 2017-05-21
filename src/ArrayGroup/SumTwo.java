package ArrayGroup;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by Wei on 2017/4/25.
 */
public class SumTwo {

    public static void main(String[] args){

        SumTwo st = new SumTwo();

        int[] input = {2,5,3,9,1,12,52,4,6,10};
        int[] input2 = {3,2,4};

        int[] result = st.twoSum(input, 13);

        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + ", ");
        }

        System.out.println();

        int[] result2 = st.twoSum(input2, 6);

        for (int i = 0; i < result2.length; i++){
            System.out.print(result2[i] + ", ");
        }
    }

    // two for loops
    public int[] twoSum(int[] nums, int target) {
        int[][] input = new int[3][4];
        System.out.println("The number of row: "+input.length);
        System.out.println("The number of column: "+ input[0].length);
        int [] result = new int[2];

        for (int i = 0; i < nums.length; i++){
            int first = nums[i];
            for (int j = i + 1; j < nums.length; j++){
                int second = nums[j];
                if  (first + second == target){
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return new int[]{0, 0};

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(target - nums[i], i);
            }
        }

        return new int[]{0, 0};
    }
}
