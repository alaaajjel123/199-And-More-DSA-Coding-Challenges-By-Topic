import java.util.Arrays;

public class MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));
        
        int n = envelopes.length;
        int[] sub = new int[n];
        sub[0] = envelopes[0][1];
        int size = 1;

        for (int i = 1; i < n; i++) {
            int num = envelopes[i][1];
            if (num > sub[size - 1]) {
                sub[size++] = num;
            } else {
                int x = binarySearch(sub, size, num);
                sub[x] = num;
            }
        }
        return size;
    }

    private int binarySearch(int[] sub, int size, int num) {
        int left = 0, right = size;
        while (left < right) {
            int mid = (left + right) / 2;
            if (num > sub[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
