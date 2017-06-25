package Recursive;

public class FastPower {
    //(a * d) % p == ((a % p) * (d % p)) % p
    public int fast(int a, int b, int n){
        if (n == 0){
            return 1 % b;
        }
        if (n == 1){
            return a % b;
        }

        long product = fast(a, b, n/2);
        product = (product * product) % b;
        if (n % 2 == 1){
            product = (a * product) % b;
        }
        return (int)product;
    }
}
