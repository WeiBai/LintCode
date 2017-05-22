package ArrayGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baiwe on 2017/5/22.
 */
public class TwoSumiii {
    HashMap<Integer, Integer> map = new HashMap<>();

    public void put(int num){
        if (map.containsKey(num)){
            map.put(num,map.get(num)+1);
        } else {
            map.put(num, 1);
        }
    }

    public boolean find(int val){
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int remain = val - num;
            if (remain == num){
                if (map.get(num) > 1){
                    return true;
                }
            } else if (map.containsKey(remain)){
                return true;
            }
        }
        return false;
    }
}
