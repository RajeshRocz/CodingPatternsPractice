package Stack;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println("Result:"+getLongestValidParentheses(")((())"));
    }

    private static int getLongestValidParentheses(String p){

        Stack<Integer> stack=new Stack<>();
        stack.push(-1);

        int max=0;

        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max=Math.max(max, i-stack.peek());
                }
            }

        }

        return max;
    }
}
