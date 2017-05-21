package DynamicProgramming;

/**
 * Created by Wei on 2017/5/21.
 */
public class KSum {
    public int kSum(int[] A, int k, int target){
        int n = A.length;
        int[][][] dp = new int[n + 1][k + 1][target + 1];

        for (int i = 0; i <= n; i++){
            dp[i][0][0] = 1;
        }

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= k && j<= i; j++){ // keypoint
                for (int t = 1; t <= target; t++){
                    dp[i][j][t] = 0;  //keypoint
                    if (t >= A[i - 1]){
                        dp[i][j][t] = dp[i - 1][j - 1][t - A[i - 1]];
                    }
                    dp[i][j][t] += dp[i - 1][j][t]; // keypoint
                }
            }
        }
        return dp[n][k][target];
    }
}
