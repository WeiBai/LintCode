package HashGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wei on 2017/5/22.
 */
public class MapLoop {
    public static void main(String[] args){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("bai","qin");

        for (Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " loves "+ entry.getValue());
        }
    }
}
