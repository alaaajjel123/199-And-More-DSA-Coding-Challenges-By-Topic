import java.util.HashMap;

public class Fibonacci {
    private HashMap<Integer, Integer> ht = new HashMap<>();

    public int fibonacci(int n) {
        if (ht.containsKey(n)) {
            return ht.get(n);
        } else {
            int result = fibonacci(n - 1) + fibonacci(n - 2);
            ht.put(n, result);
            return result;
        }
    }
}
