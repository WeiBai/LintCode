package Goldman;

import java.util.NoSuchElementException;

/**
 * Created by baiwe on 2017/12/8.
 */
public class FirstUniqueChar {

    public static void main(String[] args){
        String input = "ssba";
        System.out.println("first unqiue char: " + firstUniChar(input));
    }

    public static char firstUniChar(String s){
        if (s == null){
            throw new NoSuchElementException();
        }

        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++){
            hash[s.charAt(i)]++;
        }
        int i;
        for (i = 0; i < s.length(); i++){
            if (hash[s.charAt(i)] == 1){
                break;
            }
        }

        return s.charAt(i);
    }
}
