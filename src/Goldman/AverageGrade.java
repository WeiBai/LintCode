package Goldman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by baiwe on 2017/12/7.
 */
public class AverageGrade {

    public static void main(String[] args){
        Map<String, List<Integer>> hashMap = new HashMap<>();
        String td[][] = {{"zhang", "21"},{"li", "34"},{"zhang", "50"}, {"li", "100"}};
        for (int i = 0; i < td.length; i++){
            String[] subArray = td[i];
            //for (int j = 0; j < subArray.length; j++){
            //    String item = subArray[j];
            //    System.out.println("Output is: "+ item);
            //}
            System.out.println("Name is: " + subArray[0]);
            System.out.println("Score is: " +Integer.parseInt(subArray[1]));
            if (hashMap.containsKey(subArray[0])){
                List<Integer> list = hashMap.get(subArray[0]);
                list.add(Integer.parseInt(subArray[1]));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(subArray[1]));
                //List<Integer> list = hashMap.get(subArray[0]);
               // list.add(Integer.parseInt(subArray[1]));
                hashMap.put(subArray[0], list);
            }

        }
        double max = 0.0;
        for (Map.Entry<String, List<Integer>> entry : hashMap.entrySet()){
            List<Integer> sublist  = entry.getValue();
            int size = sublist.size();
            int sum = 0;
            double average = 0 ;
            for (int i = 0; i < size; i++){
                sum += sublist.get(i);
            }
            average = (double)sum / size;
            if (average > max){
                max = average;
            }
        }

        System.out.println("The highest average is: " + max);
    }
    // lc 319bulb switch
    // lc 387 first unique character in String
    //Probability of Knight to remain in the chessboard
    //http://www.cnblogs.com/Dylan-Java-NYC/p/7633409.html
    //http://www.geeksforgeeks.org/probability-knight-remain-chessboard/
}
