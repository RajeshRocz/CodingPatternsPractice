package KMPAlgorithm;

public class SearchPattern {

    public static void main(String[] args) {
        System.out.println("Result:" + isPatternExist("abxabcabcaby", "abcaby"));
    }

    private static boolean isPatternExist(String text, String pattern) {
        int[] lps = getLpsArray(pattern);
        int i = 0;
        int j = 1;
        int n = text.length();

        while (j < n) {
            if (text.charAt(j) == pattern.charAt(i)) {
                i++;
                j++;
                if (i == pattern.length()) {
                    return true;
                }
            } else {
                if (i > 0) {
                    i = lps[i - 1];
                } else {
                    j++;
                }
            }
        }
        return false;
    }

    private static int[] getLpsArray(String p) {
        int n = p.length();
        int[] lps = new int[n];
        int i = 0;
        int j = 1;
        lps[0] = 0;
        while (j < n) {
            if (p.charAt(i) == p.charAt(j)) {
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
        return lps;
    }
}
