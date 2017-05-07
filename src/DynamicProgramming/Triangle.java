package DynamicProgramming;

import java.util.List;

/**
 * Created by Wei on 2017/5/7.
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle){
        int[] total = new int[triangle.size()];
        int vIndex = triangle.size() - 1;

        for (int i = 0; i < triangle.size(); i++){
            total[i] = triangle.get(vIndex).get(i);
        }

        for (int i = vIndex - 1; i >= 0; i--){
            for (int j = 0; j <= i; j++){
                total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
            }
        }

        return total[0];
    }
}
