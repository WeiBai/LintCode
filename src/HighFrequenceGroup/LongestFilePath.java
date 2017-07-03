package HighFrequenceGroup;

import java.util.HashMap;

/**
 * Created by baiwe on 2017/7/3.
 */
public class LongestFilePath {
    public int longest(String input){
        if (input == null || input.length() == 0){
            return 0;
        }
        String[] folders = input.split("\n");

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        int max = 0;
        for (String folder: folders){
            int level = folder.lastIndexOf("\t") + 1;
            int length = folder.substring(level).length();

            if (folder.contains(".")){
                max = Math.max(max,map.get(level)+length);
            } else {
                map.put(level + 1, map.get(level) + length + 1);
            }
        }
        return max;
    }
}
