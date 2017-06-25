package Recursive;

public class Power {
    public static void main(String[] args){

        Power p = new Power();
        int result =  p.power(3, 0);
        System.out.println(result);
    }

    public int power(int x, int n){
        if (n == 0){
            return 1;
        }

        if (n % 2 == 0){
            int mid = power(x, n/2);
            return mid * mid;
        } else{
            return x * power(x, n - 1);
        }
    }
}
