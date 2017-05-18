package DynamicProgramming;

/**
 * Created by baiwe on 2017/5/18.
 */
public class ClimbingStair {

    public int climbing(int n){
        if (n <= 1){
            return 1;
        }

        int[] ways = new int[2];

        ways[0] = 1;
        ways[1] = 1;

        for (int i = 2; i < n + 1; i++){
            ways[i%2] = ways[(i-1)%2] + ways[(i-2)%2];
        }

        return ways[n%2];
    }
}
