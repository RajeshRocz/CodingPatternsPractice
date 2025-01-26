package Stack;

import java.util.Stack;

public class ValidParenthesisString {
    public static void main(String[] args) {
        System.out.println("Result:" + isValidString("((()*))("));

    }

    /*
    Input: s = "(*))"
    Output: true
     */
    private static boolean isValidString(String s) {

        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();


        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                open.push(i);
            } else if (s.charAt(i) == '*') {
                star.push(i);
            } else {

                if (!open.isEmpty()) {
                    open.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }

        }
        String str="73647";
        boolean matches = str.matches("-?\\\\d+(\\\\.\\\\d+)?");

        System.out.println(matches);
        //Now do left over open braces
        while (!open.isEmpty()) {
            if (star.isEmpty()) {
                return false;
            } else if (open.peek() < star.peek()) {
                open.pop();
                star.pop();
            } else {
                return false;
            }
        }

        return true;
    }
}
