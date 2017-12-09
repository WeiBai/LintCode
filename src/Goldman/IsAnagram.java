package Goldman;

import java.util.Map;



/**
 * Created by baiwe on 2017/12/8.
 */
public class IsAnagram {

    public static void main(String[] args){
        String s = "sas (";
        String t = "(as s";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        int[] hash = new int[265];
        for (int i = 0; i < s.length(); i++){
            hash[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++){
            hash[t.charAt(i)]--;
            if (hash[t.charAt(i)] < 0){
                return false;
            }
        }

        return true;
    }
}
