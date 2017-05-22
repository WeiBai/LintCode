package MISC.StringGroup;

/**
 * Created by Wei on 2017/5/23.
 */
public class Strstr {
    public static void main(String[] args){
        int i = 0;
        for (i = 0; i < 6; i++){
            System.out.println(i);
        }
        System.out.println("i after loop: "+ i);
    }

    public int strStr(String source, String target){
        if (source == null || target == null){
            return -1;
        }

        for (int i = 0; i < source.length() - target.length() + 1; i++){
            int j = 0;
            for (j = 0; j < target.length(); j++){
                if (source.charAt(i + j) != target.charAt(j)){
                    break;
                }
            }
            if (j == target.length()){
                return i;
            }
        }
        return -1;
    }
}
