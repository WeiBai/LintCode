package BinarySearch;

/**
 * Created by Wei on 2017/4/26.
 */
public class RotatedArray {

    public int search(int[] input, int target){
        if (input == null || input.length == 0){
            return -1;
        }

        int start = 0;
        int end = input.length - 1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (input[mid] == target){
                return mid;
            }

            if (input[start] < input[mid]){
                if (input[start] <= target && target <= input[mid]){
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (input[mid] <= target && target <= input[end]){
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (input[start] ==  target){
            return start;
        } else if (input[end] == target){
            return end;
        }

        return -1;
    }
}
