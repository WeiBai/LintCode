package DynamicProgramming;

import java.util.Stack;

/**
 * Created by baiwe on 2017/5/10.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int maxLength = 0;
        int leftMost = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    leftMost = i;
                } else {
                    int j = stack.pop();
                    if (stack.isEmpty()) {
                        maxLength = Math.max(maxLength, i - leftMost);
                    } else {
                        maxLength = Math.max(maxLength, i - stack.peek());
                    }
                }
            }
        }
        return maxLength;
    }
}
