package HashGroup;

import java.util.HashSet;

/**
 * Created by Wei on 2017/5/2.
 */
public class HashSetDemo {

    public static void main(String[] args){
        HashSet hs = new HashSet();

        hs.add('A');
        hs.add('C');
        hs.add('B');
        if (hs.contains('A')){
            System.out.println("This hashset contians A!");
        }

        System.out.println(hs);

        hs.remove('C');

        System.out.println(hs);
    }
}
