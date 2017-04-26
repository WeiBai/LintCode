package ArrayGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baiwe on 2017/4/26.
 */
public class RecoverRotated {

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(4);
        arr.add(5);
        arr.add(1);
        arr.add(2);
        arr.add(3);

        RecoverRotated rr = new RecoverRotated();
        rr.recover(arr);

        for (int num : arr){
            System.out.println(num);
        }
    }

    public void recover(ArrayList<Integer> input){
        for (int i = 0; i < input.size() - 1; i++){
            if (input.get(i) > input.get(i + 1)){
                reverse(input, 0, i);
                reverse(input, i + 1, input.size() - 1);
                reverse(input, 0, input.size() - 1);
                return;
            }
        }
    }

    public void reverse(ArrayList<Integer> arr, int start, int end){
        for (int i = start, j = end; i < j; i++, j--) {
            int tmp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, tmp);
        }
    }
}
