package ArrayGroup.SubArray;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by baiwe on 2017/6/22.
 */
public class SubArraySumClosest {
    public int[] SumClosest(int[] nums){
        //output
        int[] result = new int[2];
        // Exception and corner case
        if (nums == null || nums.length == 0){
            return result;
        }

        if (nums.length == 1){
            result[0] = result[1] = 0;
            return result;
        }
        // Create prefix sum index
        int len = nums.length;
        Pair[] sums = new Pair[len+1];
        int prev = 0;
        sums[0] = new Pair(0,0);
        for (int i = 1; i <= len; i++){
            sums[i] = new Pair(prev + nums[i-1],i);
            prev = sums[i].sum;
        }
        // sort
        Arrays.sort(sums, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.sum - b.sum;
            }
        });

        // find the minimum difference between sums
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++){
            if (ans > sums[i].sum - sums[i-1].sum){
                ans = sums[i].sum - sums[i-1].sum;
                int[] temp = new int[]{sums[i].index - 1, sums[i-1].index - 1};
                Arrays.sort(temp);
                result[0] = temp[0] + 1; // keypoint
                result[1] = temp[1];
            }
        }

        return result;
    }
}

class Pair{
    int sum;
    int index;
    public Pair(int sum, int index){
        this.sum = sum;
        this.index = index;
    }
}
