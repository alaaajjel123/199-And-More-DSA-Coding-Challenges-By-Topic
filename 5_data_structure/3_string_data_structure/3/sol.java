import java.util.HashMap;

public class UniqueSubstring {
    public static int maxUniqueLength(String str) {
        int maxLen = 0;
        int start = 0;
        HashMap<Character, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (seen.containsKey(currentChar)) {
                start = Math.max(start, seen.get(currentChar) + 1);
            }
            maxLen = Math.max(maxLen, i - start + 1);
            seen.put(currentChar, i);
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(maxUniqueLength("pqbrstbuvwpvy"));
    }
}
