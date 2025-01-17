package SlidingWindow;

import java.util.Arrays;

public class FindSubStringAnagramCount {

    public static void main(String[] args) {
        System.out.println("Result:" + getAnagramCountOfSubstring("caabab", "aba"));
    }

    private static int getAnagramCountOfSubstring(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (tLength > sLength) {
            return 0;
        }
        //window size = tLength

        int[] tFrequency = new int[26];

        for (int i = 0; i < tLength; i++) {

            tFrequency[t.charAt(i) - 'a'] += 1;
        }

        int left = 0;
        int right = 0;
        int[] windowFrequency = new int[26];
        int count = 0;
        while (right < sLength) {
            windowFrequency[s.charAt(right) - 'a'] += 1;
            if (right - left + 1 == tLength) {
                if (Arrays.equals(windowFrequency, tFrequency)) {
                    count++;
                }
                windowFrequency[s.charAt(left) - 'a'] -= 1;

                left++;

            }

            right++;
        }
        return count;
    }
}
