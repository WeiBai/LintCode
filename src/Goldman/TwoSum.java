package Goldman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by baiwe on 2017/12/8.
 */
public class TwoSum {

    public static void main(String[] args){
        int[] input = {2, 6, 8, 3, 1};
        int[] output = twoSum1(input, 9);
        System.out.println("output: " + output[0] + " " + output[1]);

        int[] input2 = {1, 2, 8, 9, 9};
        int count = twoSum2(input2, 10);
        System.out.println("The count is: " + count);
    }

    public static int[] twoSum1(int[] input, int target){
        if (input == null){
            return new int[]{-1, -1};
        }
        int one = -1;
        int two = -1;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < input.length; i++){
            if (hashMap.get(input[i]) != null){
                one = hashMap.get(input[i]) + 1;
                two = i + 1;
            } else {
                hashMap.put(target - input[i], i);
            }
        }
        return new int[] {one, two};
    }

    public static int twoSum2(int[] input, int target){
        if (input.length < 2){
            return 0;
        }

        int left = 0; int right = input.length - 1;
        int count = 0;
        Arrays.sort(input);
        while (left < right){
            int value = input[left] + input[right];
            if (target == value){
                count++;
                left++;
                right--;
                while(left < right && input[right] == input[right + 1]){
                    right--;
                }
                while (left < right && input[left] == input[left-1]){
                    left++;
                }
            } else if (target > value){
                right--;
            } else {
                left--;
            }
        }

        return count;
    }
}
