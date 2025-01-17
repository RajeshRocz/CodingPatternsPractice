package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithUniqueCharacters {

    public static void main(String[] args) {
        System.out.println("Result:" + getLengthOfLongestSubstringWithUniqueCharacters("abcba"));
        System.out.println("Result using map:" + getLengthOfLongestSubstringWithUniqueCharactersUsingHashMap("abcba"));
    }

    /*
    input abcba
    abc
    cba
    output 3
     */

    private static int getLengthOfLongestSubstringWithUniqueCharacters(String s) {

        int left = 0;
        int right = 0; //abcba
        Set<Character> characterSet = new HashSet<>();
        int maxLength = 0;
        while (right < s.length()) {

            while (characterSet.contains(s.charAt(right))) {
                characterSet.remove(s.charAt(left));
                left++;
            }

            characterSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, (right - left + 1));

            right++;
        }
        return maxLength;
    }

    private static int getLengthOfLongestSubstringWithUniqueCharactersUsingHashMap(String s) {

        int left = 0;
        int right = 0; //abcba
        Map<Character, Integer> characterMap = new HashMap<>();
        int maxLength = 0;
        while (right < s.length()) {
            if (characterMap.containsKey(s.charAt(right)) && characterMap.get(s.charAt(right)) >= left) {
                left = characterMap.get(s.charAt(right)) + 1;

            }
            characterMap.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, (right - left + 1));

            right++;
        }
        return maxLength;
    }
}
