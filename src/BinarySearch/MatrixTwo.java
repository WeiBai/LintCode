package BinarySearch;

/**
 * Created by Wei on 2017/4/26.
 */
public class MatrixTwo {

    private boolean find(int[][] input, int target){
        if (input == null || input.length == 0){
            return false;
        }
        if (input[0] == null || input[0].length == 0){
            return false;
        }

        int row = input.length;
        int column = input[0].length;

        int i = row - 1;
        int j = 0;

        while (j < column && i >= 0){
            if (input[i][j] == target){
                return true;
            } else if (input[i][j] > target){
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
