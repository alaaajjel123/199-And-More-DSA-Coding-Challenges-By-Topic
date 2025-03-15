public class MatrixMultiplication {

    public int matrixMultiplication(int N, int[] arr) {
        return findCost(1, N - 1, arr);
    }

    private int findCost(int i, int j, int[] arr) {
        if (i == j) {
            return 0;
        }

        int cost = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int currCost = findCost(i, k, arr) + findCost(k + 1, j, arr) + arr[i - 1] * arr[k] * arr[j];
            cost = Math.min(cost, currCost);
        }

        return cost;
    }
}
