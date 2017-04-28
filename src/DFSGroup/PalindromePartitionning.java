package DFSGroup;

import java.util.*;

/**
 * Created by Wei on 2017/4/29.
 */
public class PalindromePartitionning {

    public static void main(String[] args){
        String a = "ab";
        PalindromePartitionning pp = new PalindromePartitionning();
        System.out.println(pp.palindrome(a));
    }

    public List<List<String>> partition(String s) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();

        if (s == null){
            return result;
        }

        if (s.length() == 0){
            result.add(new ArrayList<String>());
            return result;
        }

        helper(result, new ArrayList<String>(), s, 0);
        return result;
    }

    public void helper(ArrayList<List<String>> result,
                       ArrayList<String> list,
                       String s,
                       int pos){

        if (pos == s.length()){
            result.add(new ArrayList<String>(list));
            return;
        }

        for (int i = pos; i < s.length(); i++){
            String sub = s.substring(pos, i + 1); // keypoint
            if (!palindrome(sub)){
                continue;
            }

            list.add(sub);
            helper(result, list, s, i + 1); // keypoint
            list.remove(list.size() - 1);
        }

    }

    public boolean palindrome(String input){
        for (int i = 0, j = input.length() - 1; i < j; i++, j--){
            if (input.charAt(i) != input.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
