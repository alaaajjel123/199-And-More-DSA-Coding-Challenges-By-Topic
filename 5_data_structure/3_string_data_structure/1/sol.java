import java.util.HashMap;
import java.util.Map;

public class NonRepeatingCharacter {
    public static Integer firstNonRepeatingChar(String str) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (charCount.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        
        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("repeated"));
        System.out.println(firstNonRepeatingChar("aabbcc")); 
    }
}
