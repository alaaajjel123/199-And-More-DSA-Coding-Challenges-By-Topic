public class TowerOfHanoi {
    private static int count = 0;

    public static int toh(int N, int fromm, int to, int aux) {
        count = 0;
        helper(N, fromm, to, aux);
        return count;
    }

    private static void helper(int N, int fromm, int to, int aux) {
        if (N == 1) {
            count++;
            System.out.println("Move disk " + N + " from rod " + fromm + " to rod " + to);
            return;
        }
        helper(N - 1, fromm, aux, to);
        count++;
        System.out.println("Move disk " + N + " from rod " + fromm + " to rod " + to);
        helper(N - 1, aux, to, fromm);
    }

    public static void main(String[] args) {
        System.out.println("Total moves: " + toh(3, 1, 3, 2));
    }
}