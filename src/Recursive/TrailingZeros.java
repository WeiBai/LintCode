package Recursive;

/**
 * http://bookshadow.com/weblog/2014/12/30/leetcode-factorial-trailing-zeroes/
 */
public class TrailingZeros {
    public long trail(int n){
        long count = 0;
        long x = 5;
        while(n >= x){
            count += n / x;
            x *= 5;
        }
        return count;
    }
}
