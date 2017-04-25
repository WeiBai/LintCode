package ArrayGroup;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by Wei on 2017/4/26.
 */
public class MergeArray {

    public static void main(String[] args){
        MergeArray ma = new MergeArray();

        ArrayList a = new ArrayList();
        a.add(1);
        a.add(3);

        ArrayList b = new ArrayList();
        b.add(2);
        b.add(5);

        ArrayList<Integer> result = new ArrayList<Integer>();

        result = (ArrayList)ma.merge(a, b);
        for (int num : result){
            System.out.print(num + " ");
        }

    }

    public static List<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
        //int[] result = new int[(a.length + b.length)];
        ArrayList result = new ArrayList();
        int i = 0, j = 0;
        int index = 0;

        while (i < a.size() && j < b.size() ){
            if(a.get(i) <= b.get(j)){
                result.add(a.get(i));
                i++;
            }else {
                result.add(b.get(j));
                j++;
            }
        }

        while (i < a.size()){
            result.add(a.get(i));
            i++;
        }

        while (j < b.size()){
            result.add(b.get(j));
            j++;
        }

        return result;
    }
}
