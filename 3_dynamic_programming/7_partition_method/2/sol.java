public class MinCut {
    public int minCut(String s) {
        return partitions(0, s.length() - 1, s);
    }

    private boolean isPalindrome(int start, int end, String s) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private int partitions(int start, int end, String s) {
        if (start == end || isPalindrome(start, end, s)) {
            return 0;
        }
        int minimumCuts = end - start;
        for (int endIndex = start; endIndex < end; endIndex++) {
            if (isPalindrome(start, endIndex, s)) {
                minimumCuts = Math.min(minimumCuts, 1 + partitions(endIndex + 1, end, s));
            }
        }
        return minimumCuts;
    }
}
