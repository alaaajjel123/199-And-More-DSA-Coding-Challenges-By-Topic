public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] arr = new int[n][m];
        
        for (int[] row : arr) {
            Arrays.fill(row, -1);
        }
        
        return helper(word1, word2, n - 1, m - 1, arr);
    }

    private int helper(String word1, String word2, int index1, int index2, int[][] arr) {
        if (index1 < 0) return index2 + 1;
        if (index2 < 0) return index1 + 1;

        if (arr[index1][index2] != -1) {
            return arr[index1][index2];
        }
        
        if (word1.charAt(index1) == word2.charAt(index2)) {
            arr[index1][index2] = helper(word1, word2, index1 - 1, index2 - 1, arr);
            return arr[index1][index2];
        }

        int replace = 1 + helper(word1, word2, index1 - 1, index2 - 1, arr);
        int delete = 1 + helper(word1, word2, index1 - 1, index2, arr);
        int insert = 1 + helper(word1, word2, index1, index2 - 1, arr);
        
        arr[index1][index2] = Math.min(replace, Math.min(delete, insert));
        return arr[index1][index2];
    }
}
