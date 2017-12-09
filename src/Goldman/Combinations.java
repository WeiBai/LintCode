package Goldman;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baiwe on 2017/12/9.
 */
public class Combinations {

    public static void main(String[] args){
        List<List<Integer>> result = combination(4, 2);
        for (int i = 0; i < result.size(); i++){
            System.out.println();
            List<Integer> solution = result.get(i);
            for (int j = 0; j < solution.size(); j++){
                System.out.print(solution.get(j) +" ");
            }
        }

        List<List<Character>> result2 = strCombination("asssd", 2);
        for (int i = 0; i < result2.size(); i++){
            System.out.println();
            List<Character> solution = result2.get(i);
            for (int j = 0; j < solution.size(); j++){
                System.out.print(solution.get(j) +" ");
            }
        }

    }

    public static List<List<Integer>> combination(int n, int k){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();

        helper(result, solution, n, k, 1);

        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> solution,
                              int n, int k, int start){
        if (solution.size() == k){
            result.add(new ArrayList<Integer>(solution));
            return;
        }

        for (int i = start; i <= n; i++){
            solution.add(i);
            helper(result, solution, n, k, i + 1);
            solution.remove(solution.size() - 1);
        }
    }

    public static List<List<Character>> strCombination(String s, int k){
        char[] input = s.toCharArray();
        List<List<Character>> result = new ArrayList<>();
        List<Character> solution = new ArrayList<>();
        helper2(result, solution, input, 2, 0);
        return result;
    }

    public static void helper2(List<List<Character>> result, List<Character> solution,
                               char[] input, int k, int start){

        if (solution.size() == k){
            result.add(new ArrayList<Character>(solution));
            return;
        }

        for (int i = start; i < input.length; i++){
            if (i != start && input[i] == input[i - 1]){
                continue;
            }
            solution.add(input[i]);
            helper2(result, solution, input, k, i + 1);
            solution.remove(solution.size() - 1);
        }
    }
}
