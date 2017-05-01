package StackGroup;

import java.util.Stack;

/**
 * Created by Wei on 2017/5/2.
 */
public class QueueTwoStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public QueueTwoStack() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void stack2tostack1(){
        while (!stack2.isEmpty()){ // keypoint
            stack1.push(stack2.pop());
        }
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack2.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack1.isEmpty()){
            stack2tostack1();
        }
        return stack1.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack1.isEmpty()){
            stack2tostack1();
        }
        return stack1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty(); // keypoint
    }
}
