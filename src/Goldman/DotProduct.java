package Goldman;

/**
 * Created by baiwe on 2017/12/8.
 */
public class DotProduct {

    public static void main(String[] args){
        int[] a = {1, 3};
        int[] b = {2, 4};

        System.out.println(dotPro(a, b));
    }

    public static int dotPro(int[] a, int[] b){
        if (a.length != b.length){
            throw new NumberFormatException();
        }
        if (a.length == 0 || b.length == 0 || a == null || b == null){
            throw new NumberFormatException();
        }
        int sumProduct = 0;
        for (int i = 0; i < a.length; i++){
            sumProduct += a[i] * b[i];
        }
        return sumProduct;
    }
}
