package Stack;

import java.util.Stack;

public class EvaluateExpression {

    public static void main(String[] args) {
        System.out.println("Result:" + evaluateExpression("18-(7+(2-4))"));
    }

    private static int evaluateExpression(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int currentSum = 0;
        int sign = 1;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {
                currentSum = 10 * currentSum + Character.getNumericValue(c);
            } else if (c == '+' || c == '-') {
                result += currentSum * sign;
                if (c == '-') {
                    sign = -1;
                } else {
                    sign = 1;
                }
                currentSum = 0;

            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;

            } else if (c == ')') {
                result += currentSum * sign;
                result *= stack.pop();
                result += stack.pop();
                currentSum = 0;
            }

        }
        return result + currentSum * sign;
    }
}
