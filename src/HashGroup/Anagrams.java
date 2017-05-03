package HashGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Wei on 2017/5/4.
 */
public class Anagrams {

    private List<List<String>> anagram(String[] strs){
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        if (strs == null || strs.length == 0){
            return result;
        }

        for (String str : strs){
            char[] count = new char[26];
            for (int i = 0; i < str.length(); i++){
                count[str.charAt(i) - 'a']++;
            }

            String key = new String(count);
            if (map.containsKey(key)){
                map.get(key).add(str);
            } else {
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                map.put(key, al);
            }
        }

        for (String key : map.keySet()){
            if (map.get(key).size() >= 1){
                result.add(map.get(key));
            }
        }

        return result;
    }
}
