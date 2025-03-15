import java.util.HashMap;
import java.util.Map;

public class TwoSumOptimal {
    public static int[] twoSumOptimal(int[] array, int target) {
        Map<Integer, Integer> numAvailable = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int neededVal = target - array[i];
            if (numAvailable.containsKey(neededVal)) {
                return new int[]{i, numAvailable.get(neededVal)};
            }
            numAvailable.put(array[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] result = twoSumOptimal(new int[]{2, -1, 5, 3}, 4);
        if (result.length == 2) {
            System.out.println("[" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No valid pair found");
        }
    }
}
