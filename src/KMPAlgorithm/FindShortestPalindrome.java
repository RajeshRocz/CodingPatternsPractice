package KMPAlgorithm;

public class FindShortestPalindrome {
    //leetcode 214 problem
    public static void main(String[] args) {
        System.out.println("Result:" + findShortestPalindrome("aab"));
    }

    private static String findShortestPalindrome(String s) {
        String original = s;
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();
        String temp = original + "*" + s; // this * will help if s already a palindrome
        int[] lps = new int[temp.length() + 1];
        int i = 0;
        int j = 1;
        lps[0] = 0;
        while (j < temp.length()) {
            if (temp.charAt(i) == temp.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i > 0) {
                    i = lps[i - 1];
                } else {
                    lps[j] = 0;
                    j++;
                }
            }
        }
        int difference = s.length() - lps[temp.length() - 1];

        return s.substring(0, difference) + original;
    }
}
