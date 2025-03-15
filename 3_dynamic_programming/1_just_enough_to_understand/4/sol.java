public class Fibonacci {
    public int fibonacci(int n) {
        if (n <= 1) return n;
        int prev = 0;
        int curr = 1;
        int counter = 1;
        while (counter < n) {
            int next = prev + curr;
            counter++;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
