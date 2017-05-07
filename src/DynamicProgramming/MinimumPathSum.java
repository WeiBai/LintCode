package DynamicProgramming;

/**
 * Created by Wei on 2017/5/8.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int M = grid.length;
        int N = grid[0].length;
        int[][] sum = new int[M][N];

        sum[0][0] = grid[0][0];

        for (int i = 1; i < M; i++) {
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }

        for (int j = 1; j < N; j++) {
            sum[0][j] = sum[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                sum[i][j] = Math.min(sum[i-1][j], sum[i][j-1]) + grid[i][j];
            }
        }

        return sum[M-1][N-1];
    }
}
