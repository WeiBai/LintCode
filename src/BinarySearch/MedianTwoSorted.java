package BinarySearch;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by Wei on 2017/4/26.
 */
public class MedianTwoSorted {

    public double median(int[] A, int[] B){
        int alength =  A.length;
        int blength = B.length;

        int k = alength + blength;

        if (k % 2 == 1){
            return findKth(A, 0, B, 0, k / 2 + 1);
        } else {
            return (findKth(A, 0, B, 0, k / 2 ) + findKth(A, 0, B, 0, k / 2 + 1)) / 2.0;
        }
    }

    public double findKth(int[] A, int A_start,
                       int[] B, int B_start,
                       int k){
        if (A_start >= A.length){
            return B[B_start + k -1];
        }
        if (B_start >= B.length){
            return A[A_start + k -1];
        }

        if (k == 1){
            return Math.min(A[A_start], B[B_start]);
        }

        int A_key_value = A_start + k/2 - 1 < A.length ? A[A_start + k/2 -1] : Integer.MAX_VALUE;
        int B_key_value = B_start + k/2 - 1 < B.length ? B[B_start + k/2 -1] : Integer.MAX_VALUE;

        if (A_key_value < B_key_value){
            return findKth(A, A_start + k/2, B, B_start, k - k/2);
        } else {
            return findKth(A, A_start, B, B_start + k/2, k - k /2);
        }
    }
}
