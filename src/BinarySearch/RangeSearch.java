package BinarySearch;

/**
 * Created by baiwe on 2017/4/25.
 */
public class RangeSearch {

    public int[] range(int[] input, int target){

        int[] result = new int[2];

        if (input == null || input.length == 0){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int start, end;
        // find left
         start = 0;
         end = input.length - 1;
        int mid;

        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if (input[mid] == target){
                end = mid;  // keypoint 继续向左搜索
            }else if (input[mid] < target){
                start = mid;
            } else {
                end = mid;
            }
        }

        if (input[start] == target){
            result[0] = start;
        } else if (input[end] == target){
            result[0] = end;
        }else {
            result[0] = -1;
            result[1] = -1;
            return result;
        }

        // find left
         start = 0;
         end = input.length - 1;
        //int mid;

        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if (input[mid] == target){
                start = mid;    //继续向右搜索
            }else if (input[mid] < target){
                start = mid;
            }else {
                end = mid;
            }
        }

        if (input[end] == target){
        result[1] = end;
    } else if (input[start] == target){
        result[1] = start;
    }else {
        result[0] = -1;
        result[1] = -1;
        return result;
    }

        return result;
}
}
