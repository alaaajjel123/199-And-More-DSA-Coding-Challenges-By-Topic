public class LCS {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        return helper(text1, text2, 0, 0);
    }

    private int helper(String text1, String text2, int index1, int index2) {
        if (index1 >= text1.length() || index2 >= text2.length()) {
            return 0;
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + helper(text1, text2, index1 + 1, index2 + 1);
        }

        return Math.max(helper(text1, text2, index1 + 1, index2), 
                        helper(text1, text2, index1, index2 + 1));
    }
}
