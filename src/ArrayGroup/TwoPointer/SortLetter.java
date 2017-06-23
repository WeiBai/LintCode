package ArrayGroup.TwoPointer;

/**
 * Created by baiwe on 2017/6/23.
 */
public class SortLetter {
    public void sort(char[] chars){
        if (chars == null || chars.length == 0){
            return;
        }

        int left = 0, right = chars.length - 1;

        while(left <= right){
            while(left <= right && Character.isLowerCase(chars[left])){
                left++;
            }
            while(left <= right && Character.isUpperCase(chars[right])){
                right--;
            }

            if (left <= right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }

        return;
    }
}
