package MISC.StringGroup;

/**
 * Created by baiwe on 2017/5/26.
 */
public class KMP {

    public static void main(String[] args){

        String t = "womendoushixiaohangjia";
        String p = "xiao";
        int r = search(p,t);
        System.out.println("The value of r is: " + r);
    }

    public static int search(String pattern, String text){
        int[] lsp = computeLspTable(pattern);
        int j = 0;  // Number of chars matched in pattern

        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                // Fall back in the pattern
                j = lsp[j - 1];  // Strictly decreasing
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                // Next char matched, increment position
                j++;
                if (j == pattern.length())
                    return i - (j - 1);
            }
        }

        return -1;  // Not found
    }

    public static int[] computeLspTable(String pattern){
        int[] lsp = new int[pattern.length()];
        lsp[0] = 0;
        for (int i = 1; i < pattern.length(); i++){
            int j = lsp[i - 1];
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = lsp[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)){
                j++;
            }
            lsp[i] = j;
        }
        return lsp;
    }
}
