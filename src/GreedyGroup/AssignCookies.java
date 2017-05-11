package GreedyGroup;

import java.util.Arrays;

/**
 * Created by Wei on 2017/5/11.
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);

        int i, j;
        for (i = j = 0; i < g.length && j < s.length; j++){
            if (g[i] <= s[j]){
                i++;
            }
        }
        return i;
    }
}
