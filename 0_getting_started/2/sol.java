public class MonotonicArray {
    public static boolean isMonotonic(int[] array) {
        if (array.length <= 1) return true;

        int first = array[0];
        int last = array[array.length - 1];

        if (first > last) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) return false;
            }
        } else if (first == last) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] != array[i + 1]) return false;
            }
        } else {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1}));
        System.out.println(isMonotonic(new int[]{1, 2, 2, 3}));
        System.out.println(isMonotonic(new int[]{5, 4, 3, 3, 1}));
        System.out.println(isMonotonic(new int[]{1, 3, 2}));
    }
}
