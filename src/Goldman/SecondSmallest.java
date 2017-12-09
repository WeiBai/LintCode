package Goldman;

/**
 * Created by baiwe on 2017/12/8.
 */
public class SecondSmallest {

    public static void main(String[] args){
        int[] input = {1, 2, 3, 4, -1};

        System.out.println(secondSmallest(input));
    }

    public static int secondSmallest(int[] input){
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < input.length; i++){
            if (input[i] < first){
                second = first;
                first = input[i];
            } else if (input[i] < second){
                second = input[i];
            }
        }
        return second;
    }
}
