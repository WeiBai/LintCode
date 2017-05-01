package StackGroup;

import java.util.Stack;

/**
 * Created by Wei on 2017/5/2.
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack(){
        stack = new Stack();
        minStack = new Stack();
    }

    public void push(int num){
        if (minStack.isEmpty()){
            minStack.push(num);
        } else {
            minStack.push(Math.min(num,minStack.peek()));
        }
        stack.push(num);
    }

    public int pop(){
        minStack.pop();
        return stack.pop();
    }

    public int peek(){
        return stack.peek();
    }

    public int min(){
        return minStack.peek();
    }
}
