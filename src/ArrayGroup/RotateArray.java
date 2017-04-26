package ArrayGroup;

import java.util.ArrayList;

/**
 * Created by baiwe on 2017/4/26.
 */
public class RotateArray {

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);


        RotateArray ra = new RotateArray();
        ra.rotate(arr, 2);

        for (int num : arr){
            System.out.println(num);
        }

        String sample = "this";
        System.out.println(sample.substring(0,2));
    }

    public void rotate(ArrayList<Integer> arr, int p){

            reverse(arr, 0, p - 1);
            reverse(arr, p, arr.size() - 1);
            reverse(arr, 0, arr.size() - 1);

    }

    public void reverse(ArrayList<Integer> arr, int start, int end){
        for (int i = start, j = end; i < j; i++, j--){
            int tmp = arr.get(i);
            arr.set(i,arr.get(j));
            arr.set(j,tmp);
        }
    }
}
