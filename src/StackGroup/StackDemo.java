package StackGroup;

/**
 * Created by Wei on 2017/4/18.
 */
import java.util.*;

public class StackDemo {
    public static void main(String[] args){
        Stack stack = new Stack();

        stack.push(2);
        stack.push(3);
        stack.push(1);

        System.out.println(stack.pop());
    }
}
