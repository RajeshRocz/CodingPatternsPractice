package Stack;

import java.util.Stack;

public class BaseBallGame {

    public static void main(String[] args) {
        System.out.println("Result:"+calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }


    public static int calPoints(String[] operations) {

        Stack<Integer> stack=new Stack<>();
        for(String operation:operations){
            if(operation.matches("-?\\d+")){
                stack.push(Integer.parseInt(operation));
            } else if("C".equals(operation)){
                stack.pop();
            } else if("D".equals(operation)){
                int value=stack.peek();
                stack.push(2*value);
            } else if("+".equals(operation)){
                int peek=stack.pop();
                int prev=stack.pop();
                int total=peek+prev;
                stack.push(prev);
                stack.push(peek);
                stack.push(total);
            }
        }
        return getTotal(stack);
    }

    private static int getTotal(Stack<Integer> newStack){
        if(newStack.isEmpty()){
            return 0;
        }
        int sum=0;
        while(!newStack.isEmpty()){
            sum+=newStack.pop();
        }
        return sum;
    }
}
