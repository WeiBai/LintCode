package DynamicProgramming;

/**
 * Created by Wei on 2017/5/8.
 */
public class LongestIncreasingContinuesSubsequence {
    public int longestIncreasingContinuousSubsequence(int[] A){
        if (A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;
        int answer = 1;

        // from left to right
        int length = 1; // just A[0] itselft

        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                length++;
            } else {
                length = 1;
            }
            answer = Math.max(answer, length);
        }

        // from right to left
        length = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                length++;
            } else {
                length = 1;
            }
            answer = Math.max(answer, length);
        }

        return answer;
    }
}
