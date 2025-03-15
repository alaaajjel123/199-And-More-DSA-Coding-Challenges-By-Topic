import java.util.*;

public class Partition {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                if (i == j) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j) && (j == i + 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        helper(0, new ArrayList<>(), s, dp, res);
        return res;
    }

    private void helper(int index, List<String> curr, String s, boolean[][] dp, List<List<String>> res) {
        int n = s.length();
        if (index >= n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i < n; i++) {
            if (dp[index][i]) {
                curr.add(s.substring(index, i + 1));
                helper(i + 1, curr, s, dp, res);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
