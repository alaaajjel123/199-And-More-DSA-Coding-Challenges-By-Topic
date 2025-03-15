public class MinCut {
    public int minCut(String s) {
        int n = s.length();
        Boolean[][] isPalindrome = new Boolean[n][n];
        Integer[][] minCuts = new Integer[n][n];

        for (int l = 1; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;
                if (i == j) {
                    isPalindrome[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j) && (j == i + 1 || isPalindrome[i + 1][j - 1] == true)) {
                    isPalindrome[i][j] = true;
                } else {
                    isPalindrome[i][j] = false;
                }
            }
        }

        return partitions(0, n - 1, s, isPalindrome, minCuts);
    }

    private int partitions(int start, int end, String s, Boolean[][] isPalindrome, Integer[][] minCuts) {
        if (start == end || isPalindrome[start][end]) {
            return 0;
        }
        if (minCuts[start][end] != null) {
            return minCuts[start][end];
        }

        int minimumCuts = end - start;

        for (int endIndex = start; endIndex < end; endIndex++) {
            if (isPalindrome[start][endIndex]) {
                minimumCuts = Math.min(minimumCuts, 1 + partitions(endIndex + 1, end, s, isPalindrome, minCuts));
            }
        }

        minCuts[start][end] = minimumCuts;
        return minCuts[start][end];
    }
}
