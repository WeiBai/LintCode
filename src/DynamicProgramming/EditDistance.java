package DynamicProgramming;

/**
 * Created by baiwe on 2017/5/10.
 */
public class EditDistance {
    public int minDistance(String s1, String s2){
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < n + 1; i++){ // row 0
            dp[0][i] = i;
        }

        for (int i = 0; i < m + 1; i++){ // column 0
            dp[i][0] = i;
        }

        for (int i = 1; i < m + 1; i++){
            for (int j = 1; j < n + 1; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1],
                            Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }

        return dp[m][n];
    }
}
