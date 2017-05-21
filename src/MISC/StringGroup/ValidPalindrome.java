package MISC.StringGroup;

/**
 * Created by Wei on 2017/5/22.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String str) {
        if (str.length() == 0) {
            return true;
        }
        int i = 0;
        int j = str.length() - 1;

        while(i < j){
            while(i < j && !Character.isLetterOrDigit(str.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(str.charAt(j))) j--;
            if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(j))) {
                return false;
            }
            i++;
            j--; // keypoint
        }
        return true;
    }
}
