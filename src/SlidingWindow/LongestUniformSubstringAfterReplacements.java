package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestUniformSubstringAfterReplacements {

    public static void main(String[] args) {
        System.out.println("Result:" + getSubStringCount("aabcdcca", 2));
    }

    private static int getSubStringCount(String s, int k) {
        //aabcdcca
        int left = 0, right = 0;
        int maxLength = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        while (right < s.length()) {
            Character c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(c));
            int numOfCharToReplace = (right - left + 1) - maxFreq;
            if (numOfCharToReplace > k) {
                Character leftCharacter = s.charAt(left);
                freqMap.put(leftCharacter, freqMap.get(leftCharacter) - 1);
                left++;
            }
            maxLength = right - left + 1;
            right++;

        }

        return maxLength;
    }
}
