package HashMapsAndSets;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(longestSubstring("pwwkew"));

    }
    private static int lengthOfLongestSubstring(String s){
        if(s==null){
            return 0;
        }

        Map<Character, Integer> uniqueMap=new HashMap<>();
        int left=0,right=0;
        int n=s.length();
        int maxLength=Integer.MIN_VALUE;
        while(right<n){
            char c=s.charAt(right);
            if(uniqueMap.containsKey(c) && uniqueMap.get(c)>=left){
                left=uniqueMap.get(c)+1;
            }
            uniqueMap.put(c,right);
            maxLength=Math.max(maxLength, right-left+1);
            right++;
        }
return maxLength;
    }

    private static String longestSubstring(String s){
        if(s==null){
            return "";
        }

        Map<Character, Integer> uniqueMap=new HashMap<>();
        int left=0,right=0;
        int n=s.length();
        StringBuilder sb=new StringBuilder();
        int maxLength=Integer.MIN_VALUE;
        while(right<n){
            char c=s.charAt(right);
            if(uniqueMap.containsKey(c) && uniqueMap.get(c)>=left){
                left=uniqueMap.get(c)+1;
            }
            uniqueMap.put(c,right);
            if(maxLength< right-left+1){
                maxLength=right-left+1;
                sb= new StringBuilder(s.substring(left, right+1));
            }
            right++;
        }
        return sb.toString();
    }
}
