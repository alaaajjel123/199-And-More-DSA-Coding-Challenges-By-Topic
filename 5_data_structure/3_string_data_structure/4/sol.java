import java.util.*;

public class AnagramGrouping {
    public static List<List<String>> groupAnagrams(String[] strings) {
        if (strings.length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> hash = new HashMap<>();
        
        for (String str : strings) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            
            if (!hash.containsKey(sortedString)) {
                hash.put(sortedString, new ArrayList<>());
            }
            hash.get(sortedString).add(str);
        }
        
        return new ArrayList<>(hash.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat","ate", "nat", "bat"};
        System.out.println(groupAnagrams(input));
    }
}
