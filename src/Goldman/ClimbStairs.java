package Goldman;

/**
 * Created by baiwe on 2017/12/8.
 */
public class ClimbStairs {

    public static void main(String[] args){
        System.out.println(climb3(3));
        System.out.println(climb3(4));
        System.out.println(climb3(5));
        System.out.println(climb3(6));
        System.out.println("-------------------------");
        System.out.println(climb3_2(3));
        System.out.println(climb3_2(4));
        System.out.println(climb3_2(5));
        System.out.println(climb3_2(6));
    }

    public static int climb(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int current = 2;
        int prev = 1;
        for (int i = 3; i <= n; i++){
            current += prev;
            prev = current - prev;
        }

        return current;
    }

    public static int climb3(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (n == 3){
            return 4;
        }

        int three = 4;
        int two = 2;
        int one = 1;
        for (int i = 4; i <= n; i++){
            three = three + two + one;
            int tempone = two;
            two = three - two - one;
            one = tempone;
        }

        return three;
    }

    public static int climb3_2(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (n == 3){
            return 4;
        }
        int[] input = new int[n + 1];
        input[2] = 2;
        input[1] = 1;
        input[0] = 1;
        for (int i = 3; i <= n; i++){
            input[i] = input[i-1] + input[i-2] + input[i-3];
        }

        return input[n];
    }
}
