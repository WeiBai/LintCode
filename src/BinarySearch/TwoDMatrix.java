package BinarySearch;

/**
 * Created by Wei on 2017/4/26.
 */
public class TwoDMatrix {
    int[][] input = {{1,2},{3,4}};

    private boolean findTarget(int[][] input, int target){
        if (input == null || input.length == 0){
            return false;
        }
        if (input[0] == null || input[0].length == 0){
            return false;
        }

        int row = input.length;
        int column = input[0].length;

        // find row <= target
        int start = 0;
        int end = row - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (input[mid][0] == target){
                return true;
            } else if (input[mid][0] <= target){
                start = mid;
            } else {
                end = mid;
            }
        }

        if (input[end][0] <= target){
            row = end;
        } else if (input[start][0] <= target){
            row = start;
        } else {
            return false;
        }

        // find the column == target
        start = 0;
        end = column - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (input[row][mid] == target){
                return true;
            } else if (input[row][mid] < target){
                start = mid;
            } else {
                end = mid;
            }
        }

        if (input[row][start] ==  target){
            return true;
        } else if (input[row][end] ==  target){
            return true;
        }

        return false;
    }
}
