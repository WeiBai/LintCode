package HighFrequenceGroup;

import java.util.*;

/**
 * Created by baiwe on 2017/6/28.
 */
public class WordAbbre {
    public String[] wordsAbbreviation(String[] words) {
        if (words == null || words.length == 0) {
            return new String[0];
        }

        int length = words.length;
        String[] res = new String[length];
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            results.add(i);
        }

        int len = 2;
        while (!results.isEmpty()) {
            Map<String, Set<Integer>> map = new HashMap<>();
            for (int i : results) {
                String curr = words[i];
                String abbre = curr.length() <= len + 1 ? curr : curr.substring(0, len - 1) + (curr.length() - len) + curr.charAt(curr.length() - 1);

                if (map.containsKey(abbre)) {
                    map.get(abbre).add(i);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    map.put(abbre, set);
                }
            }

            List<Integer> next = new ArrayList<>();
            for (String word : map.keySet()) {
                if (map.get(word).size() == 1) {
                    int index = -1 ;
                    for (int i : map.get(word)) {
                        index = i;
                    }
                    res[index] = word;
                } else {
                    for (int i : map.get(word)) {
                        next.add(i);
                    }
                }
            }
            results = next;
            len++;
        }

        return res;
    }
}
