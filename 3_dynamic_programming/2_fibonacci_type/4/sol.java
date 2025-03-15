public class Tribonacci {
    public int tribonacci(int n) {
        int zero = 0;
        int one = 1;
        int two = 1;
        if (n <= 1) return n;
        if (n == 2) return two;
        int next = 0;
        for (int i = 3; i <= n; i++) {
            next = zero + one + two;
            zero = one;
            one = two;
            two = next;
        }
        return next;
    }
}
