public class KthSymbol {
    public static int kthSymbol(int n, int k) {
        if (n == 1) return 0;

        int length = (int) Math.pow(2, n - 1);
        int mid = length / 2;

        if (k <= mid) {
            return kthSymbol(n - 1, k);
        } else {
            return 1 - kthSymbol(n - 1, k - mid);
        }
    }

    public static void main(String[] args) {
        System.out.println(kthSymbol(3, 3));
        System.out.println(kthSymbol(4, 5));
        System.out.println(kthSymbol(5, 12));
    }
}