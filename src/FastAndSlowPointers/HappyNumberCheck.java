package FastAndSlowPointers;

public class HappyNumberCheck {

    public static void main(String[] args) {

        System.out.println("Is 23 happy number:"+isHappyNumber(23));
        System.out.println("Is 116 happy number:"+isHappyNumber(116));
    }

    private static boolean isHappyNumber(int n){
        int slow=n,fast=n;
        while(true){
            slow=getNextSum(slow);
            fast=getNextSum(getNextSum(fast));
            if(fast==1){
                return true;
            } else if (slow==fast) {
                System.out.println(slow);
                return false;
            }
        }
    }

    private static int getNextSum(int n){
        int nextSum=0;
        while(n!=0){
            int lastDigit=n%10;
            nextSum+=lastDigit*lastDigit;
            n=n/10;
        }
        return nextSum;
    }
}
