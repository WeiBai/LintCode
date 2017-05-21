package DynamicProgramming;

/**
 * Created by Wei on 2017/5/21.
 */
public class BackPackii {
    public int backPack(int m, int[] A, int[] V){
        if (m <= 0 || A == null || V == null || A.length == 0 || V.length == 0 || A.length != V.length){
            return 0;
        }

        int[][] dp = new int[A.length+1][m+1];
        dp[0][0] = 0;

        for (int i = 1; i <= A.length; i++){
            for (int j = 0; j <= m; j++){
                if (j >= A[i - 1]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[A.length][m];
    }
}
