public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        return number_of_operations(word1, word2, 0, 0, n, m);
    }
    
    private int number_of_operations(String word1, String word2, int index1, int index2, int n, int m) {
        if (index1 == n && index2 == m) {
            return 0;
        }
        if (index1 == n) {
            return m - index2;
        }
        if (index2 == m) {
            return n - index1;
        }
        
        if (word1.charAt(index1) == word2.charAt(index2)) {
            return number_of_operations(word1, word2, index1 + 1, index2 + 1, n, m);
        }
        
        int insert = 1 + number_of_operations(word1, word2, index1, index2 + 1, n, m);
        int delete = 1 + number_of_operations(word1, word2, index1 + 1, index2, n, m);
        int replace = 1 + number_of_operations(word1, word2, index1 + 1, index2 + 1, n, m);
        
        return Math.min(insert, Math.min(delete, replace));
    }
}
