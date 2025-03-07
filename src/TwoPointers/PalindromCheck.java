package TwoPointers;

public class PalindromCheck {
    public static void main(String[] args) {

        System.out.println(isPalindrome("hello, world!"));

    }

    //Alphanumeric palindrome check
    private static boolean isPalindrome(String s) {
        if (s.length() < 2) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
                continue;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;

        }

        return true;
    }
}
