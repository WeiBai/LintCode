package DynamicProgramming;

/**
 * Created by Wei on 2017/5/8.
 */
public class LongestIncreasingSubsequence {

    public int LIS(int[] A){
        if (A == null || A.length == 0){
            return 0;
        }
        int[] f = new int[A.length];
        int result = 1;
        int len = A.length;
        //int max = 0;
        for (int i = 0; i < len; i++){
            f[i] = 1;
            for (int j = 0; j < i; j++){
                if (A[j] < A[i] && f[i] < f[j] + 1){
                    f[i] = f[j] + 1;
                }
            }
            if (f[i] > result){
                result = f[i];
            }
        }

        return result;
    }
}
