import java.util.Arrays;

public class SortedSquaredArray {
    public static int[] sortedSquared(int[] array) {
        int n = array.length;
        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {
            newArray[i] = array[i] * array[i];
        }

        Arrays.sort(newArray);
        return newArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquared(new int[]{-5, 1, 2})));
        System.out.println(Arrays.toString(sortedSquared(new int[]{0, 1, 2})));
        System.out.println(Arrays.toString(sortedSquared(new int[]{})));
    }
}