import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Find the Longest Substring Without Repeating Characters
 * Description: Given a string s, find the length of the longest substring that does not contain any repeating characters.
 * Example:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 */
public class McdTest {

    public static void main(String[] args) {
        int length= getNonRepeatingCharacterLength("pwwkew");
        System.out.println("Length:"+length);
    }

    private static int getNonRepeatingCharacterLength(String s){

        if(null==s || s.isEmpty()){
            return 0;
        }
        //pwwkew

        int left=0,right=0;
        int n=s.length();//6

        Map<Character, Integer> charcterMap=new HashMap<>();
        int maxLength=0;

        while(right<n) {

            char c = s.charAt(right);

            if (charcterMap.containsKey(c) && left<=charcterMap.get(c)) {
                left = charcterMap.get(c) + 1;
            }

            charcterMap.put(c, right);
            maxLength=Math.max(maxLength, right-left+1);

            right++;
        }

        return maxLength;
    }
}
