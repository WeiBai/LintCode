package BinarySearch;

/**
 * Created by Wei on 2017/4/26.
 */
public class FindPeakElement {
    public int findPeak(int[] input){
        if (input == null || input.length == 0){
            return -1;
        }

        int start = 0;
        int end = input.length - 1;
        int mid;

        while (start + 1 < end){
            mid = start + (end - start) / 2;
            if (input[mid] < input[mid + 1]){
                start = mid;
            }else if(input[mid] < input[mid-1]){
                end = mid;
            } else {
                end = mid; //keypoint
            }
        }

        if (input[start] < input[end]){
            return end;
        } else {
            return start;
        }
    }
}
