package DynamicProgramming;

/**
 * Created by Wei on 2017/5/8.
 */
public class JumpGame {
    public boolean jump(int[] A) {
        boolean[] states = new boolean[A.length];
        states[0] = true;

        for (int i = 1; i < A.length; i++){
            for (int j = 0; j < i; j++){
                if (states[j] && A[j] + j > i){
                    states[i] = true;
                    break;
                }
            }
        }
        return states[A.length - 1];
    }
}
