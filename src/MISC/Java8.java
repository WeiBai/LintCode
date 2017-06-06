package MISC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Optional;

/**
 * Created by baiwe on 2017/6/1.
 */
public class Java8 {
    public static void main(String[] args){
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = 0;

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("The value of count is: " + count);

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);

        filtered = strings.stream().sorted().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Sorted Filtered List: " + filtered);

        Java8 java8 = new Java8();
        Integer value1 = null;
        Integer value2 = new Integer(108);

        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.of(value2);

        System.out.println("The sum of two values: " + java8.sum(a, b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){
        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Seconf parameter is present: " + b.isPresent());

        Integer value1 = a.orElse(new Integer(0));

        Integer value2 = b.get();
        return value1 + value2;
    }

    public interface Predicate<T>{
        boolean test(T t);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for (T e: list){
            if (p.test(e)){
                result.add(e);
            }
        }
        return result;
    }

    // Thread t = new Thread(() -> System.out.println("Hello world"));
}
