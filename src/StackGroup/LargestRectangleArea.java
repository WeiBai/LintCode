package StackGroup;

import java.util.Stack;

/**
 * Created by Wei on 2017/5/2.
 */
public class LargestRectangleArea {

    public int largest(int[] height){
        if (height == null || height.length == 0){
            return 0;
        }

        Stack<Integer> stack = new Stack();
        int max = 0;

        for (int i = 0; i <= height.length; i++){
            int val = (i == height.length) ? -1: height[i];

            while (!stack.isEmpty() && val <= height[stack.peek()]){
                int h = height[stack.pop()];
                int w = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }

            stack.push(i);
        }

        return max;
    }
}
