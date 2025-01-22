package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesisExpression {

    public static void main(String[] args) {
        System.out.println("Result:"+isValidParenthesisExpression("(((())))"));
        System.out.println("Result:"+isValidParenthesisExpressionNoHashMAp("((())))"));
    }

    private static boolean isValidParenthesisExpression(String expression) {
        Map<Character, Character> parenthesisMap = new HashMap<>();
        parenthesisMap.put('(', ')');
        parenthesisMap.put('[', ']');
        parenthesisMap.put('{', '}');
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (parenthesisMap.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || c != parenthesisMap.get(stack.pop())) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isValidParenthesisExpressionNoHashMAp(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (c=='(' ) {
                stack.push(')');
            } else if (c=='[') {
                stack.push(']');
            } else if (c=='{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || c!=stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
