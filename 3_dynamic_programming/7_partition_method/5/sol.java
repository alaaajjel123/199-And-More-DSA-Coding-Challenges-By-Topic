import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            dp[i] = false;
        }

        return checkBuild(s, wordDict, dp, n - 1);
    }

    private boolean checkBuild(String s, List<String> wordDict, boolean[] dp, int i) {
        if (i < 0) {
            return true;
        }

        if (dp[i]) {
            return true;
        }

        for (String word : wordDict) {
            if (i - word.length() + 1 >= 0 && s.substring(i - word.length() + 1, i + 1).equals(word) && checkBuild(s, wordDict, dp, i - word.length())) {
                dp[i] = true;
                return true;
            }
        }

        dp[i] = false;
        return false;
    }
}
