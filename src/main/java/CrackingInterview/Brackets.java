package CrackingInterview;

import java.util.Stack;

/**
 * Created by Dawei on 10/6/2016.
 */
public class Brackets {
    public static boolean isBalanced(String expression) {
        if (expression.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            else {
                if (stack.empty())
                    return false;
                char curr = stack.pop();
                if ((curr == '(' && c != ')') || (curr == '[' && c != ']') || (curr == '{' && c != '}'))
                    return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "{[()]}()()()()()()()";
        System.out.println(isBalanced(s));
    }
}
