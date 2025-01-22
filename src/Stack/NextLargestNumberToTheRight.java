package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextLargestNumberToTheRight {

    public static void main(String[] args) {

        var result=getResult(new int[]{5,2,4,6,1});
        Arrays.stream(result).forEach(System.out::print);
    }

    private static int[] getResult(int[] nums){
        Stack<Integer> stack=new Stack<>();

        int[] result=new int[nums.length];

        for(int i=nums.length-1;i>-1;i--){

            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                stack.pop();
            }
            result[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }
}
