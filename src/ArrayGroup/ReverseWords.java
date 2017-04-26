package ArrayGroup;

/**
 * Created by baiwe on 2017/4/26.
 */
public class ReverseWords {

    public static void main(){

    }

    public String reverse(String input){
        if (input == null || input.length() == 0){
            return "";
        }

        String[] array = input.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = array.length - 1; i >= 0; i--){
            if (array[i].equals("")) { // keypoint
                continue;
            }
            sb.append(array[i]).append(" ");
        }

        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1).trim();
    }
}
