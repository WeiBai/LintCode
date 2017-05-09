package DynamicProgramming;

import java.util.Set;

/**
 * Created by baiwe on 2017/5/9.
 */
public class WordBreak {

    //"leetcode" [leet, code]
    public boolean wordBreak(String s, Set<String> dict){
        if (s.length() == 0){
            return true;
        }

        boolean[] canSegment = new boolean[s.length() + 1]; // keypoint
        canSegment[0] = true;
        int maxl = maxLength(dict);

        for (int i = 1; i <= s.length(); i++){
            canSegment[i] = false;
            for (int lastwordLength = 1;
                    lastwordLength <= maxl && lastwordLength <= i; // keypoint
                    lastwordLength++){
                if (!canSegment[i - lastwordLength]){
                    continue;
                }

                if (dict.contains(s.substring(i - lastwordLength, i))){
                    canSegment[i] = true;
                    break;
                }
            }
        }
        return canSegment[s.length()];
    }

    public int maxLength(Set<String> dict){
        int max = 0;
        for (String word : dict){
            max = Math.max(max, word.length());
        }
        return max;
    }
}
