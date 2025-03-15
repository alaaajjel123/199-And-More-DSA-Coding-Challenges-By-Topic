public class Josephus {
    public static int findTheWinner(int n, int k) {
        return josephus(n, k) + 1;
    }

    private static int josephus(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (josephus(n - 1, k) + k) % n;
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner(6, 3));
        System.out.println(findTheWinner(7, 4));
    }
}