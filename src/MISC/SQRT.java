package MISC;

/**
 * Created by baiwe on 2017/6/25.
 */
public class SQRT {
    public int sqrt(int n){
        long start = 0;
        long end = n;
        while(start + 1 < end){
            long mid = start + (end - start)/2;
            if (mid * mid <= n){
                start = mid;
            }else {
                end = mid;
            }
        }
        if (end * end <= n){
            return (int) end;
        }else {
            return (int) start;
        }
    }
}
